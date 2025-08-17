package com.NindyBun.watercanteens.items;

import net.minecraft.world.item.ItemStack;

public interface Drinkable {
    int getMaxUses();
    int getRemainingUses(ItemStack stack);
}
