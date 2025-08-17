package com.NindyBun.watercanteens.registries;

import com.NindyBun.watercanteens.WaterCanteens;
import com.NindyBun.watercanteens.items.CanteenTiers;
import com.NindyBun.watercanteens.items.EmptyCanteen;
import com.NindyBun.watercanteens.items.FilledCanteen;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class RegItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, WaterCanteens.MODID);

    public static final DeferredHolder<Item, EmptyCanteen> EMPTY_LEATHER_CANTEEN = ITEMS.register("empty-leather-canteen", () -> new EmptyCanteen(CanteenTiers.LEATHER));
    public static final DeferredHolder<Item, EmptyCanteen> EMPTY_IRON_CANTEEN = ITEMS.register("empty-iron-canteen", () -> new EmptyCanteen(CanteenTiers.IRON));
    public static final DeferredHolder<Item, EmptyCanteen> EMPTY_GOLD_CANTEEN = ITEMS.register("empty-gold-canteen", () -> new EmptyCanteen(CanteenTiers.GOLD));
    public static final DeferredHolder<Item, EmptyCanteen> EMPTY_DIAMOND_CANTEEN = ITEMS.register("empty-diamond-canteen", () -> new EmptyCanteen(CanteenTiers.DIAMOND));
    public static final DeferredHolder<Item, EmptyCanteen> EMPTY_NETHERITE_CANTEEN = ITEMS.register("empty-netherite-canteen", () -> new EmptyCanteen(CanteenTiers.NETHERITE));
    public static final DeferredHolder<Item, EmptyCanteen> EMPTY_DRAGON_CANTEEN = ITEMS.register("empty-dragon-canteen", () -> new EmptyCanteen(CanteenTiers.DRAGON));

    public static final DeferredHolder<Item, FilledCanteen> FILLED_LEATHER_CANTEEN = ITEMS.register("filled-leather-canteen",
            () -> new FilledCanteen(CanteenTiers.LEATHER).setEmptyCanteen(EMPTY_LEATHER_CANTEEN.get()));
    public static final DeferredHolder<Item, FilledCanteen> FILLED_IRON_CANTEEN = ITEMS.register("filled-iron-canteen",
            () -> new FilledCanteen(CanteenTiers.IRON).setEmptyCanteen(EMPTY_IRON_CANTEEN.get()));
    public static final DeferredHolder<Item, FilledCanteen> FILLED_GOLD_CANTEEN = ITEMS.register("filled-gold-canteen",
            () -> new FilledCanteen(CanteenTiers.GOLD).setEmptyCanteen(EMPTY_GOLD_CANTEEN.get()));
    public static final DeferredHolder<Item, FilledCanteen> FILLED_DIAMOND_CANTEEN = ITEMS.register("filled-diamond-canteen",
            () -> new FilledCanteen(CanteenTiers.DIAMOND).setEmptyCanteen(EMPTY_DIAMOND_CANTEEN.get()));
    public static final DeferredHolder<Item, FilledCanteen> FILLED_NETHERITE_CANTEEN = ITEMS.register("filled-netherite-canteen",
            () -> new FilledCanteen(CanteenTiers.NETHERITE).setEmptyCanteen(EMPTY_NETHERITE_CANTEEN.get()));
    public static final DeferredHolder<Item, FilledCanteen> FILLED_DRAGON_CANTEEN = ITEMS.register("filled-dragon-canteen",
            () -> new FilledCanteen(CanteenTiers.DRAGON).setEmptyCanteen(EMPTY_DRAGON_CANTEEN.get()));

}
