package com.NindyBun.watercanteens.registries;

import com.NindyBun.watercanteens.WaterCanteens;
import com.NindyBun.watercanteens.helpers.Utilities;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class RegTabs {
    public static final DeferredRegister<CreativeModeTab>TABS = DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB, WaterCanteens.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CREATIVE_TAB = TABS.register("creative_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable(Utilities.addModID("itemGroup", "watercanteens_tab")))
            .icon(() -> RegItems.LEATHER_CANTEEN.get().getDefaultInstance())
            .displayItems(((itemDisplayParameters, output) -> {
                RegItems.ITEMS.getEntries().forEach((itemDeferredHolder -> output.accept(itemDeferredHolder.get())));
            }))
            .build());
}
