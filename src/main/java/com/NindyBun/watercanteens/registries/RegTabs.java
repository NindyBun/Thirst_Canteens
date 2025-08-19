package com.NindyBun.watercanteens.registries;

import com.NindyBun.watercanteens.WaterCanteens;
import com.NindyBun.watercanteens.helpers.Utilities;
import com.NindyBun.watercanteens.items.CanteenTiers;
import com.NindyBun.watercanteens.items.Drinkable;
import com.NindyBun.watercanteens.items.EmptyCanteen;
import com.NindyBun.watercanteens.items.FilledCanteen;
import dev.ghen.thirst.api.ThirstHelper;
import dev.ghen.thirst.content.purity.WaterPurity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.Map;

public class RegTabs {
    public static final DeferredRegister<CreativeModeTab>TABS = DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB, WaterCanteens.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CREATIVE_TAB = TABS.register("creative_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable(Utilities.addModID("itemGroup", "watercanteens_tab")))
            .icon(() -> RegItems.EMPTY_CANTEENS.get(RegItems.MATERIAL[0]).get().getDefaultInstance())
            .displayItems(((itemDisplayParameters, output) -> {
                for (int i = 0; i < RegItems.MATERIAL.length; i++) {
                    output.accept(RegItems.EMPTY_CANTEENS.get(RegItems.MATERIAL[i]).get().getDefaultInstance());
                    for (int ii = 0; ii < RegItems.PURITY.length; ii++) {
                        if (!RegItems.MATERIAL[i].equals("dragon")) {
                            output.accept((WaterPurity.addPurity(RegItems.FILLED_CANTEENS.get(RegItems.MATERIAL[i]).get(RegItems.PURITY[ii]).get().getDefaultInstance(), ii)));
                        } else if (ii >= 2) {
                            output.accept((WaterPurity.addPurity(RegItems.FILLED_CANTEENS.get(RegItems.MATERIAL[i]).get(RegItems.PURITY[ii]).get().getDefaultInstance(), ii)));
                        }
                    }
                }
                //addCanteenVariants(output, RegItems.FILLED_LEATHER_CANTEEN.get());
                //addCanteenVariants(output, RegItems.FILLED_IRON_CANTEEN.get());
                //addCanteenVariants(output, RegItems.FILLED_COPPER_CANTEEN.get());
                //addCanteenVariants(output, RegItems.FILLED_GOLD_CANTEEN.get());
                //addCanteenVariants(output, RegItems.FILLED_DIAMOND_CANTEEN.get());
                //addCanteenVariants(output, RegItems.FILLED_NETHERITE_CANTEEN.get());
                //addCanteenVariants(output, RegItems.FILLED_DRAGON_CANTEEN.get());
            }))
            .build());

    public static void addCanteenVariants(CreativeModeTab.Output output, FilledCanteen item) {
        output.accept(item.getEmptyCanteen().getDefaultInstance());
        output.accept(WaterPurity.addPurity(item.getDefaultInstance(), 0));
        output.accept(WaterPurity.addPurity(item.getDefaultInstance(), 1));
        output.accept(WaterPurity.addPurity(item.getDefaultInstance(), 2));
        output.accept(WaterPurity.addPurity(item.getDefaultInstance(), 3));
    }
}
