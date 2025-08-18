package com.NindyBun.watercanteens.data;
import com.NindyBun.watercanteens.WaterCanteens;
import com.NindyBun.watercanteens.registries.RegItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;


public class ItemModelGen extends ItemModelProvider {
    public ItemModelGen(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, WaterCanteens.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        String name = RegItems.EMPTY_LEATHER_CANTEEN.getId().getPath();
        withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-bottle-leather"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-handle"));

        name = RegItems.FILLED_LEATHER_CANTEEN.getId().getPath();
        withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-bottle-leather"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-handle"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-waterdrip"));

        name = RegItems.EMPTY_IRON_CANTEEN.getId().getPath();
        withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-bottle-iron"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-handle"));

        name = RegItems.FILLED_IRON_CANTEEN.getId().getPath();
        withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-bottle-iron"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-handle"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-waterdrip"));

        name = RegItems.EMPTY_COPPER_CANTEEN.getId().getPath();
        withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-bottle-copper"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-handle"));

        name = RegItems.FILLED_COPPER_CANTEEN.getId().getPath();
        withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-bottle-copper"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-handle"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-waterdrip"));

        name = RegItems.EMPTY_GOLD_CANTEEN.getId().getPath();
        withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-bottle-gold"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-handle"));

        name = RegItems.FILLED_GOLD_CANTEEN.getId().getPath();
        withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-bottle-gold"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-handle"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-waterdrip"));

        name = RegItems.EMPTY_DIAMOND_CANTEEN.getId().getPath();
        withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-bottle-diamond"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-handle"));

        name = RegItems.FILLED_DIAMOND_CANTEEN.getId().getPath();
        withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-bottle-diamond"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-handle"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-waterdrip"));

        name = RegItems.EMPTY_NETHERITE_CANTEEN.getId().getPath();
        withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-bottle-netherite"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-handle"));

        name = RegItems.FILLED_NETHERITE_CANTEEN.getId().getPath();
        withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-bottle-netherite"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-handle"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-waterdrip"));

        name = RegItems.EMPTY_DRAGON_CANTEEN.getId().getPath();
        withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-bottle-netherite"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-handle"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-eye"));

        name = RegItems.FILLED_DRAGON_CANTEEN.getId().getPath();
        withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-bottle-netherite"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-handle"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-eye"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-waterdrip"));

    }

}
