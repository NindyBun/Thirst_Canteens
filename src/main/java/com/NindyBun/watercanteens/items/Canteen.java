package com.NindyBun.watercanteens.items;

import com.NindyBun.watercanteens.WaterCanteens;
import com.NindyBun.watercanteens.registries.RegComponents;
import com.NindyBun.watercanteens.registries.RegItems;
import dev.ghen.thirst.content.registry.ThirstComponent;
import dev.ghen.thirst.foundation.common.item.DrinkableItem;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import javax.annotation.Nullable;
import java.awt.*;
import java.util.List;

public class Canteen extends DrinkableItem {
    private final int amount;

    public Canteen(int amount) {
        super(new Properties().stacksTo(1)
                .component(RegComponents.WATER_AMOUNT.get(), 0)
        );
        this.amount = amount;
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return stack.getItem().equals(RegItems.DRAGON_CANTEEN.get());
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.literal(stack.get(RegComponents.WATER_AMOUNT) + " / " + this.amount).withColor(Color.CYAN.darker().getRGB()));
    }

    @Override
    public boolean isBarVisible(ItemStack stack) {
        return stack.get(RegComponents.WATER_AMOUNT.get()) > 0;
    }

    @Override
    public int getBarWidth(ItemStack stack) {
        return Math.round(13.0F - (float) (stack.get(RegComponents.WATER_AMOUNT.get()) / this.amount) * 13.0F);
    }

    @Override
    public int getBarColor(ItemStack stack) {
        float stackMaxDamage = (float)this.amount;
        float f = Math.max(0.0F, (stackMaxDamage - (stack.get(RegComponents.WATER_AMOUNT.get()) / stackMaxDamage)));
        return Mth.hsvToRgb(f / 3.0F, 1.0F, 1.0F);
    }

    public static float getHasWater(ItemStack stack, @Nullable ClientLevel level, @Nullable LivingEntity p_entity, int seed) {
        return stack.get(RegComponents.WATER_AMOUNT.get()) > 0 ? 1.0f : 0f;
    }
}
