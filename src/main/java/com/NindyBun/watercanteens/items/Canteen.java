package com.NindyBun.watercanteens.items;

import com.NindyBun.watercanteens.WaterCanteens;
import com.NindyBun.watercanteens.registries.RegComponents;
import com.NindyBun.watercanteens.registries.RegItems;
import dev.ghen.thirst.content.registry.ThirstComponent;
import dev.ghen.thirst.foundation.common.item.DrinkableItem;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.awt.*;
import java.util.List;

public class Canteen extends Item {
    private final int maxAmount;

    public Canteen(int maxAmount) {
        super(new Properties().stacksTo(1)
                .component(RegComponents.WATER_AMOUNT.get(), 0)
        );
        this.maxAmount = maxAmount;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        Player player = livingEntity instanceof Player ? (Player) livingEntity : null;

        if (player instanceof ServerPlayer serverPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
            serverPlayer.gameEvent(GameEvent.EAT);
            serverPlayer.getFoodData().eat(0, 0);

            int leftAmount = this.getLeftAmount(stack);
            stack.set(RegComponents.WATER_AMOUNT.get(), Math.max(0, leftAmount-1));
        }

        if (player != null) {
            player.awardStat(Stats.ITEM_USED.get(this));
        }
        return stack;
    }



    public int getMaxAmount() {
        return this.maxAmount;
    }

    public int getLeftAmount(ItemStack stack) {
        return this.maxAmount - stack.get(RegComponents.WATER_AMOUNT.get());
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 32;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level p_42993_, @NotNull Player p_42994_, @NotNull InteractionHand p_42995_) {
        ItemStack stack = p_42994_.getItemInHand(p_42995_);
        if (stack.get(RegComponents.WATER_AMOUNT.get()) <= 0) return InteractionResultHolder.pass(stack);

        return super.use(p_42993_, p_42994_, p_42995_);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return stack.getItem().equals(RegItems.DRAGON_CANTEEN.get());
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.literal(stack.get(RegComponents.WATER_AMOUNT) + " / " + this.maxAmount).withColor(Color.CYAN.darker().getRGB()));
    }

    @Override
    public boolean isBarVisible(ItemStack stack) {
        return stack.get(RegComponents.WATER_AMOUNT.get()) > 0;
    }

    @Override
    public int getBarWidth(ItemStack stack) {
        return Math.round(13.0F - (float) (stack.get(RegComponents.WATER_AMOUNT.get()) / this.maxAmount) * 13.0F);
    }

    @Override
    public int getBarColor(ItemStack stack) {
        float stackMaxDamage = (float)this.maxAmount;
        float f = Math.max(0.0F, (stackMaxDamage - (stack.get(RegComponents.WATER_AMOUNT.get()) / stackMaxDamage)));
        return Mth.hsvToRgb(f / 3.0F, 1.0F, 1.0F);
    }

    public static float getHasWater(ItemStack stack, @Nullable ClientLevel level, @Nullable LivingEntity p_entity, int seed) {
        return stack.get(RegComponents.WATER_AMOUNT.get()) > 0 ? 1.0f : 0f;
    }
}
