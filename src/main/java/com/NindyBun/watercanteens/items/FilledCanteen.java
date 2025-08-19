package com.NindyBun.watercanteens.items;

import com.NindyBun.watercanteens.WaterCanteens;
import com.NindyBun.watercanteens.helpers.Utilities;
import com.NindyBun.watercanteens.registries.RegItems;
import dev.ghen.thirst.Thirst;
import dev.ghen.thirst.content.purity.WaterPurity;
import dev.ghen.thirst.content.registry.ThirstComponent;
import dev.ghen.thirst.content.thirst.PlayerThirst;
import dev.ghen.thirst.foundation.util.MathHelper;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

import java.awt.*;
import java.util.List;

public class FilledCanteen extends Item implements Drinkable{
    private final CanteenTiers canteenTier;
    private Item emptyCanteen;

    public FilledCanteen(CanteenTiers canteenTier, int purity) {
        super(new Properties().stacksTo(1).durability(canteenTier.getMaxUses()).component(ThirstComponent.PURITY, purity));
        this.canteenTier = canteenTier;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        Player player = livingEntity instanceof Player ? (Player) livingEntity : null;
        if (player instanceof ServerPlayer serverPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
            serverPlayer.gameEvent(GameEvent.DRINK);
            player.awardStat(Stats.ITEM_USED.get(this));
            if (!player.getAbilities().instabuild) {
                stack.hurtAndBreak(1, (ServerLevel) level, player, item -> {});
            }
        }
        if (player == null || !player.getAbilities().instabuild) {
            if (stack.isEmpty()) {
                return new ItemStack(this.emptyCanteen);
            }
        }
        level.gameEvent(livingEntity, GameEvent.ITEM_INTERACT_FINISH, livingEntity.getEyePosition());
        return stack;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        BlockHitResult context = MathHelper.getPlayerPOVHitResult(level, player, ClipContext.Fluid.ANY);
        BlockPos blockPos = context.getBlockPos();
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        BlockState blockState = level.getBlockState(blockPos);
        int needed = stack.getDamageValue();
        ItemStack filled = stack;
        /*
            @fill[0] = purity
            @fill[1] = damage value
            @fill[2] = handled
        */
        int[] fill = Utilities.fillCanteen(filled, needed, level, blockPos, blockEntity, blockState);
        if (fill[2] == 1) {
            if (WaterPurity.getPurity(filled) != fill[0]) {
                if (this.canteenTier.equals(CanteenTiers.LEATHER)) {
                    filled = RegItems.FILLED_CANTEENS.get(RegItems.MATERIAL[0]).get(RegItems.PURITY[fill[0]]).get().getDefaultInstance();
                } else if (this.canteenTier.equals(CanteenTiers.IRON)) {
                    filled = RegItems.FILLED_CANTEENS.get(RegItems.MATERIAL[1]).get(RegItems.PURITY[fill[0]]).get().getDefaultInstance();
                } else if (this.canteenTier.equals(CanteenTiers.COPPER)) {
                    filled = RegItems.FILLED_CANTEENS.get(RegItems.MATERIAL[2]).get(RegItems.PURITY[fill[0]]).get().getDefaultInstance();
                } else if (this.canteenTier.equals(CanteenTiers.GOLD)) {
                    filled = RegItems.FILLED_CANTEENS.get(RegItems.MATERIAL[3]).get(RegItems.PURITY[fill[0]]).get().getDefaultInstance();
                } else if (this.canteenTier.equals(CanteenTiers.DIAMOND)) {
                    filled = RegItems.FILLED_CANTEENS.get(RegItems.MATERIAL[4]).get(RegItems.PURITY[fill[0]]).get().getDefaultInstance();
                } else if (this.canteenTier.equals(CanteenTiers.NETHERITE)) {
                    filled = RegItems.FILLED_CANTEENS.get(RegItems.MATERIAL[5]).get(RegItems.PURITY[fill[0]]).get().getDefaultInstance();
                } else if (this.canteenTier.equals(CanteenTiers.DRAGON)) {
                    filled = RegItems.FILLED_CANTEENS.get(RegItems.MATERIAL[6]).get(RegItems.PURITY[Math.max(fill[0], this.canteenTier.getPurity())]).get().getDefaultInstance();
                }
            }
            filled.setDamageValue(fill[1]);
            level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.BOTTLE_FILL, SoundSource.NEUTRAL, 1.0F, 1.0F);
        }

        player.startUsingItem(hand);
        return InteractionResultHolder.consume(filled);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return this.canteenTier == CanteenTiers.DRAGON;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.literal(this.getRemainingUses(stack) + " / " + this.canteenTier.getMaxUses()).withColor(Color.CYAN.darker().getRGB()));
        if (this.canteenTier.equals(CanteenTiers.DRAGON))
            tooltipComponents.add(Component.translatable("tooltip." + WaterCanteens.MODID + ".dragon-canteen-purity").withColor(Color.GRAY.darker().getRGB()));
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 32;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    public FilledCanteen setEmptyCanteen(Item emptyCanteen) {
        this.emptyCanteen = emptyCanteen;
        return this;
    }

    public Item getEmptyCanteen() {
        return this.emptyCanteen;
    }

    public CanteenTiers getCanteenTier() {
        return this.canteenTier;
    }

    @Override
    public int getMaxUses() {
        return this.canteenTier.getMaxUses();
    }

    @Override
    public int getRemainingUses(ItemStack stack) {
        return this.getMaxUses() - stack.getDamageValue();
    }
}
