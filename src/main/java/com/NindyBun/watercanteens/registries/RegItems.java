package com.NindyBun.watercanteens.registries;

import com.NindyBun.watercanteens.WaterCanteens;
import com.NindyBun.watercanteens.items.CanteenTiers;
import com.NindyBun.watercanteens.items.EmptyCanteen;
import com.NindyBun.watercanteens.items.FilledCanteen;
import dev.ghen.thirst.content.purity.WaterPurity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RegItems {
    public static final String[] PURITY = {"dirty", "slightly-dirty", "acceptable", "purified"};
    public static final String[] MATERIAL = {"leather", "iron", "copper", "gold", "diamond", "netherite", "dragon"};

    /*public static final Map<String, String> PURITY = Stream.of(new String[][]{
            {"dirty", "dirty"},
            {"slightly-dirty", "slightly-dirty"},
            {"acceptable", "acceptable"},
            {"purified", "purified"}
    }).collect(Collectors.collectingAndThen(Collectors.toMap(data -> data[0], data -> data[1]), Collections::<String, String> unmodifiableMap));*/

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, WaterCanteens.MODID);

//    public static final DeferredHolder<Item, EmptyCanteen> EMPTY_LEATHER_CANTEEN = ITEMS.register("empty-leather-canteen", () -> new EmptyCanteen(CanteenTiers.LEATHER));
//    public static final DeferredHolder<Item, EmptyCanteen> EMPTY_COPPER_CANTEEN = ITEMS.register("empty-copper-canteen", () -> new EmptyCanteen(CanteenTiers.COPPER));
//    public static final DeferredHolder<Item, EmptyCanteen> EMPTY_IRON_CANTEEN = ITEMS.register("empty-iron-canteen", () -> new EmptyCanteen(CanteenTiers.IRON));
//    public static final DeferredHolder<Item, EmptyCanteen> EMPTY_GOLD_CANTEEN = ITEMS.register("empty-gold-canteen", () -> new EmptyCanteen(CanteenTiers.GOLD));
//    public static final DeferredHolder<Item, EmptyCanteen> EMPTY_DIAMOND_CANTEEN = ITEMS.register("empty-diamond-canteen", () -> new EmptyCanteen(CanteenTiers.DIAMOND));
//    public static final DeferredHolder<Item, EmptyCanteen> EMPTY_NETHERITE_CANTEEN = ITEMS.register("empty-netherite-canteen", () -> new EmptyCanteen(CanteenTiers.NETHERITE));
//    public static final DeferredHolder<Item, EmptyCanteen> EMPTY_DRAGON_CANTEEN = ITEMS.register("empty-dragon-canteen", () -> new EmptyCanteen(CanteenTiers.DRAGON));

    public static final Map<String, DeferredHolder<Item, EmptyCanteen>> EMPTY_CANTEENS = new HashMap<>();
    public static final Map<String, Map<String, DeferredHolder<Item, FilledCanteen>>> FILLED_CANTEENS = new HashMap<>();

    public static void generateCanteens() {
        for (int i = 0; i < MATERIAL.length; i++) {
            CanteenTiers tier = CanteenTiers.valueOf(MATERIAL[i].toUpperCase());
            EMPTY_CANTEENS.put(MATERIAL[i], ITEMS.register("empty-"+MATERIAL[i]+"-canteen", () -> new EmptyCanteen(tier)));

            Map<String, DeferredHolder<Item, FilledCanteen>> canteens = new HashMap<>();
            int finalI = i;

            for (int ii = 0; ii < PURITY.length; ii++) {
                int finalIi = ii;
                if (!RegItems.MATERIAL[i].equals("dragon")) {
                    canteens.put(PURITY[ii], ITEMS.register("filled-" + MATERIAL[i] + "-canteen-" + PURITY[ii],
                            () -> new FilledCanteen(tier, finalIi).setEmptyCanteen(EMPTY_CANTEENS.get(MATERIAL[finalI]).get())));
                } else if (ii >= 2) {
                    canteens.put(PURITY[ii], ITEMS.register("filled-" + MATERIAL[i] + "-canteen-" + PURITY[ii],
                            () -> new FilledCanteen(tier, finalIi).setEmptyCanteen(EMPTY_CANTEENS.get(MATERIAL[finalI]).get())));
                }
                //WaterPurity.addPurity(canteens.get(PURITY[ii]).get().getDefaultInstance(), ii);
            }
            FILLED_CANTEENS.put(MATERIAL[i], canteens);
        }
    }

    /*public static final DeferredHolder<Item, FilledCanteen> FILLED_LEATHER_CANTEEN_DIRTY = ITEMS.register("filled-leather-canteen",
            () -> new FilledCanteen(CanteenTiers.LEATHER, CanteenTiers.LEATHER.getPurity()).setEmptyCanteen(EMPTY_LEATHER_CANTEEN.get()));

    public static final DeferredHolder<Item, FilledCanteen> FILLED_IRON_CANTEEN_DIRTY = ITEMS.register("filled-iron-canteen",
            () -> new FilledCanteen(CanteenTiers.IRON, CanteenTiers.IRON.getPurity()).setEmptyCanteen(EMPTY_IRON_CANTEEN.get()));

    public static final DeferredHolder<Item, FilledCanteen> FILLED_COPPER_CANTEEN_DIRTY = ITEMS.register("filled-copper-canteen",
            () -> new FilledCanteen(CanteenTiers.COPPER, CanteenTiers.COPPER.getPurity()).setEmptyCanteen(EMPTY_COPPER_CANTEEN.get()));

    public static final DeferredHolder<Item, FilledCanteen> FILLED_GOLD_CANTEEN_DIRTY = ITEMS.register("filled-gold-canteen",
            () -> new FilledCanteen(CanteenTiers.GOLD, CanteenTiers.GOLD.getPurity()).setEmptyCanteen(EMPTY_GOLD_CANTEEN.get()));

    public static final DeferredHolder<Item, FilledCanteen> FILLED_DIAMOND_CANTEEN_DIRTY = ITEMS.register("filled-diamond-canteen",
            () -> new FilledCanteen(CanteenTiers.DIAMOND, CanteenTiers.DIAMOND.getPurity()).setEmptyCanteen(EMPTY_DIAMOND_CANTEEN.get()));

    public static final DeferredHolder<Item, FilledCanteen> FILLED_NETHERITE_CANTEEN_DIRTY = ITEMS.register("filled-netherite-canteen",
            () -> new FilledCanteen(CanteenTiers.NETHERITE, CanteenTiers.NETHERITE.getPurity()).setEmptyCanteen(EMPTY_NETHERITE_CANTEEN.get()));

    public static final DeferredHolder<Item, FilledCanteen> FILLED_DRAGON_CANTEEN_DIRTY = ITEMS.register("filled-dragon-canteen",
            () -> new FilledCanteen(CanteenTiers.DRAGON, CanteenTiers.DRAGON.getPurity()).setEmptyCanteen(EMPTY_DRAGON_CANTEEN.get()));*/

}
