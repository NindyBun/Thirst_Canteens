package com.NindyBun.watercanteens;

import com.NindyBun.watercanteens.data.Generator;
import com.NindyBun.watercanteens.items.Canteen;
import com.NindyBun.watercanteens.registries.RegComponents;
import com.NindyBun.watercanteens.registries.RegItems;
import com.NindyBun.watercanteens.registries.RegTabs;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import org.checkerframework.checker.units.qual.C;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

import java.awt.*;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(WaterCanteens.MODID)
public class WaterCanteens {
    public static final String MODID = "watercanteens";
    public static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public WaterCanteens(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        RegComponents.COMPONENTS.register(modEventBus);
        RegItems.ITEMS.register(modEventBus);
        RegTabs.TABS.register(modEventBus);

        modEventBus.addListener(Generator::gatherData);
        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = WaterCanteens.MODID, value = Dist.CLIENT)
    static class ClientModEvents {
        @SubscribeEvent
        static void onClientSetup(FMLClientSetupEvent event) {
            event.enqueueWork(() -> {
                ItemProperties.register(RegItems.LEATHER_CANTEEN.get(), ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "water"), Canteen::getHasWater);
                ItemProperties.register(RegItems.IRON_CANTEEN.get(), ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "water"), Canteen::getHasWater);
                ItemProperties.register(RegItems.GOLD_CANTEEN.get(), ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "water"), Canteen::getHasWater);
                ItemProperties.register(RegItems.DIAMOND_CANTEEN.get(), ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "water"), Canteen::getHasWater);
                ItemProperties.register(RegItems.NETHERITE_CANTEEN.get(), ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "water"), Canteen::getHasWater);
                ItemProperties.register(RegItems.DRAGON_CANTEEN.get(), ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "water"), Canteen::getHasWater);
            });
        }
    }
}
