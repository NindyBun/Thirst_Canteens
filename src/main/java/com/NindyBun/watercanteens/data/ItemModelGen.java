package com.NindyBun.watercanteens.data;
import com.NindyBun.watercanteens.WaterCanteens;
import com.NindyBun.watercanteens.items.CanteenTiers;
import com.NindyBun.watercanteens.items.EmptyCanteen;
import com.NindyBun.watercanteens.items.FilledCanteen;
import com.NindyBun.watercanteens.registries.RegItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class ItemModelGen extends ItemModelProvider {
    public ItemModelGen(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, WaterCanteens.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for (int i = 0; i < RegItems.MATERIAL.length; i++) {
            String name = RegItems.EMPTY_CANTEENS.get(RegItems.MATERIAL[i]).getId().getPath();
            if (!Objects.equals(RegItems.MATERIAL[i], "dragon")) {
                withExistingParent(name, mcLoc("item/generated"))
                        .texture("layer0", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-bottle-" + RegItems.MATERIAL[i]))
                        .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-handle"));
            } else {
                withExistingParent(name, mcLoc("item/generated"))
                        .texture("layer0", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-bottle-netherite"))
                        .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-handle"))
                        .texture("layer2", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-eye"));
            }
            for (int ii = 0; ii < RegItems.PURITY.length; ii++) {
                if (!Objects.equals(RegItems.MATERIAL[i], "dragon")) {
                    String name1 = RegItems.FILLED_CANTEENS.get(RegItems.MATERIAL[i]).get(RegItems.PURITY[ii]).getId().getPath();
                    withExistingParent(name1, mcLoc("item/generated"))
                            .texture("layer0", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-bottle-" + RegItems.MATERIAL[i]))
                            .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-handle"))
                            .texture("layer2", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-waterdrip"));
                } else if (ii >= 2) {
                    String name1 = RegItems.FILLED_CANTEENS.get(RegItems.MATERIAL[i]).get(RegItems.PURITY[ii]).getId().getPath();
                    withExistingParent(name1, mcLoc("item/generated"))
                            .texture("layer0", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-bottle-netherite"))
                            .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-handle"))
                            .texture("layer2", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-eye"))
                            .texture("layer3", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-waterdrip"));
                }
            }
        }
        /*
        String name = RegItems.EMPTY_LEATHER_CANTEEN.getId().getPath();
        withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-bottle-leather"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-handle"));

        name = RegItems.FILLED_LEATHER_CANTEEN.getId().getPath();
        withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-bottle-leather"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-handle"))
                .texture("layer2", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-waterdrip"));

        name = RegItems.EMPTY_IRON_CANTEEN.getId().getPath();
        withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-bottle-iron"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-handle"));

        name = RegItems.FILLED_IRON_CANTEEN.getId().getPath();
        withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-bottle-iron"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-handle"))
                .texture("layer2", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-waterdrip"));

        name = RegItems.EMPTY_COPPER_CANTEEN.getId().getPath();
        withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-bottle-copper"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-handle"));

        name = RegItems.FILLED_COPPER_CANTEEN.getId().getPath();
        withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-bottle-copper"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-handle"))
                .texture("layer2", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-waterdrip"));

        name = RegItems.EMPTY_GOLD_CANTEEN.getId().getPath();
        withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-bottle-gold"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-handle"));

        name = RegItems.FILLED_GOLD_CANTEEN.getId().getPath();
        withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-bottle-gold"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-handle"))
                .texture("layer2", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-waterdrip"));

        name = RegItems.EMPTY_DIAMOND_CANTEEN.getId().getPath();
        withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-bottle-diamond"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-handle"));

        name = RegItems.FILLED_DIAMOND_CANTEEN.getId().getPath();
        withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-bottle-diamond"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-handle"))
                .texture("layer2", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-waterdrip"));

        name = RegItems.EMPTY_NETHERITE_CANTEEN.getId().getPath();
        withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-bottle-netherite"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-handle"));

        name = RegItems.FILLED_NETHERITE_CANTEEN.getId().getPath();
        withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-bottle-netherite"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-handle"))
                .texture("layer2", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-waterdrip"));

        name = RegItems.EMPTY_DRAGON_CANTEEN.getId().getPath();
        withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-bottle-netherite"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-handle"))
                .texture("layer2", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-eye"));

        name = RegItems.FILLED_DRAGON_CANTEEN.getId().getPath();
        withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-bottle-netherite"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-handle"))
                .texture("layer2", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-eye"))
                .texture("layer3", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-waterdrip"));
        */
    }

}
