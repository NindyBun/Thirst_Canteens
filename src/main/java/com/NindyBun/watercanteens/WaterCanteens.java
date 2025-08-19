package com.NindyBun.watercanteens;

import com.NindyBun.watercanteens.data.Generator;
import com.NindyBun.watercanteens.items.EmptyCanteen;
import com.NindyBun.watercanteens.items.FilledCanteen;
import com.NindyBun.watercanteens.registries.RegItems;
import com.NindyBun.watercanteens.registries.RegRecipes;
import com.NindyBun.watercanteens.registries.RegTabs;
import dev.ghen.thirst.Thirst;
import dev.ghen.thirst.content.purity.WaterPurity;
import dev.ghen.thirst.content.registry.ThirstComponent;
import dev.ghen.thirst.foundation.common.event.RegisterThirstValueEvent;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
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

import java.util.Map;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(WaterCanteens.MODID)
public class WaterCanteens {
    public static final String MODID = "watercanteens";
    public static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public WaterCanteens(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        RegItems.generateCanteens();
        RegItems.ITEMS.register(modEventBus);
        RegTabs.TABS.register(modEventBus);
        RegRecipes.RECIPES.register(modEventBus);
        modEventBus.addListener(Generator::gatherData);
        NeoForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void registerDrinks(RegisterThirstValueEvent event) {
        for (Map.Entry<String, Map<String, DeferredHolder<Item, FilledCanteen>>> entry : RegItems.FILLED_CANTEENS.entrySet()) {
            for (Map.Entry<String, DeferredHolder<Item, FilledCanteen>> entry1 : entry.getValue().entrySet()) {
                event.addDrink(entry1.getValue().get(), 6, 8);
                event.addContainer(entry1.getValue().get());
            }
        }
        //event.addDrink(RegItems.FILLED_LEATHER_CANTEEN.get(), 6, 8);
        //event.addDrink(RegItems.FILLED_IRON_CANTEEN.get(), 6, 8);
        //event.addDrink(RegItems.FILLED_COPPER_CANTEEN.get(), 6, 8);
        //event.addDrink(RegItems.FILLED_GOLD_CANTEEN.get(), 6, 8);
        //event.addDrink(RegItems.FILLED_DIAMOND_CANTEEN.get(), 6, 8);
        //event.addDrink(RegItems.FILLED_NETHERITE_CANTEEN.get(), 6, 8);
        //event.addDrink(RegItems.FILLED_DRAGON_CANTEEN.get(), 6, 8);
        //event.addContainer(RegItems.FILLED_LEATHER_CANTEEN.get());
        //event.addContainer(RegItems.FILLED_IRON_CANTEEN.get());
        //event.addContainer(RegItems.FILLED_COPPER_CANTEEN.get());
        //event.addContainer(RegItems.FILLED_GOLD_CANTEEN.get());
        //event.addContainer(RegItems.FILLED_DIAMOND_CANTEEN.get());
        //event.addContainer(RegItems.FILLED_NETHERITE_CANTEEN.get());
        //event.addContainer(RegItems.FILLED_DRAGON_CANTEEN.get());
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

        }
    }
}
