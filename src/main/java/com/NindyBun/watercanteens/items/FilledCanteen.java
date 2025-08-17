package com.NindyBun.watercanteens.items;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;

import java.awt.*;
import java.util.List;

public class FilledCanteen extends Item implements Drinkable{
    public final CanteenTiers canteenTier;
    private Item emptyCanteen;

    public FilledCanteen(CanteenTiers canteenTier) {
        super(new Properties().stacksTo(1).durability(canteenTier.getMaxUses()));
        this.canteenTier = canteenTier;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.literal(this.getRemainingUses(stack) + " / " + this.canteenTier.getMaxUses()).withColor(Color.CYAN.darker().getRGB()));
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

    @Override
    public int getMaxUses() {
        return this.canteenTier.getMaxUses();
    }

    @Override
    public int getRemainingUses(ItemStack stack) {
        return this.getMaxUses() - stack.getDamageValue();
    }
}
