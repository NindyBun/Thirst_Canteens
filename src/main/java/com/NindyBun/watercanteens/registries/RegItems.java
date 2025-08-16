package com.NindyBun.watercanteens.registries;

import com.NindyBun.watercanteens.WaterCanteens;
import com.NindyBun.watercanteens.items.Canteen;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class RegItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, WaterCanteens.MODID);

    public static final DeferredHolder<Item, Canteen> LEATHER_CANTEEN = ITEMS.register("leather-canteen", () -> new Canteen(6));
    public static final DeferredHolder<Item, Canteen> IRON_CANTEEN = ITEMS.register("iron-canteen", () -> new Canteen(12));
    public static final DeferredHolder<Item, Canteen> GOLD_CANTEEN = ITEMS.register("gold-canteen", () -> new Canteen(32));
    public static final DeferredHolder<Item, Canteen> DIAMOND_CANTEEN = ITEMS.register("diamond-canteen", () -> new Canteen(48));
    public static final DeferredHolder<Item, Canteen> NETHERITE_CANTEEN = ITEMS.register("netherite-canteen", () -> new Canteen(64));
    public static final DeferredHolder<Item, Canteen> DRAGON_CANTEEN = ITEMS.register("dragon-canteen", () -> new Canteen(64));

}
