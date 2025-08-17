package com.NindyBun.watercanteens.items;

import com.NindyBun.watercanteens.WaterCanteens;
import com.NindyBun.watercanteens.registries.RegComponents;
import com.NindyBun.watercanteens.registries.RegItems;
import dev.ghen.thirst.content.purity.WaterPurity;
import dev.ghen.thirst.foundation.util.MathHelper;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.awt.*;
import java.util.List;

public class EmptyCanteen extends Item {
    private final CanteenTiers canteenTier;

    public EmptyCanteen(CanteenTiers canteenTier) {
        super(new Properties().stacksTo(1));
        this.canteenTier = canteenTier;
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        BlockHitResult context = MathHelper.getPlayerPOVHitResult(level, player, ClipContext.Fluid.ANY);
        BlockPos blockPos = context.getBlockPos();
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        BlockState blockState = level.getBlockState(blockPos);
        int needed = this.canteenTier.getMaxUses();
        ItemStack filled = ItemStack.EMPTY;
        boolean handled = false;

        if (this.canteenTier.equals(CanteenTiers.LEATHER)) {
            filled = RegItems.FILLED_LEATHER_CANTEEN.get().getDefaultInstance();
        } else if (this.canteenTier.equals(CanteenTiers.IRON)) {
            filled = RegItems.FILLED_IRON_CANTEEN.get().getDefaultInstance();
        } else if (this.canteenTier.equals(CanteenTiers.GOLD)) {
            filled = RegItems.FILLED_GOLD_CANTEEN.get().getDefaultInstance();
        } else if (this.canteenTier.equals(CanteenTiers.DIAMOND)) {
            filled = RegItems.FILLED_DIAMOND_CANTEEN.get().getDefaultInstance();
        } else if (this.canteenTier.equals(CanteenTiers.NETHERITE)) {
            filled = RegItems.FILLED_NETHERITE_CANTEEN.get().getDefaultInstance();
        } else if (this.canteenTier.equals(CanteenTiers.DRAGON)) {
            filled = RegItems.FILLED_DRAGON_CANTEEN.get().getDefaultInstance();
        }

        if (level.getFluidState(blockPos).is(FluidTags.WATER)) {
            filled.setDamageValue(0);
            handled = true;
        }

        if (handled) {
            WaterPurity.addPurity(filled, Math.max(this.canteenTier.getPurity(), WaterPurity.getBlockPurity(level, blockPos)));
            player.setItemInHand(hand, filled);
            level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.BOTTLE_FILL, SoundSource.NEUTRAL, 1.0F, 1.0F);
        }

        return InteractionResultHolder.success(stack);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return this.canteenTier == CanteenTiers.DRAGON;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.literal("0 / " + this.canteenTier.getMaxUses()).withColor(Color.CYAN.darker().getRGB()));
    }
}
