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
        String name = RegItems.LEATHER_CANTEEN.getId().getPath();
        withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-bottle-leather"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-handle"))
                .override().predicate(ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "water"), 1f)
                .model(withExistingParent(name+"-1", mcLoc("item/generated"))
                        .texture("layer0", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-bottle-leather"))
                        .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-handle"))
                        .texture("layer2", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-waterdrip")));

        name = RegItems.IRON_CANTEEN.getId().getPath();
        withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-bottle-iron"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-handle"))
                .override().predicate(ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "water"), 1f)
                .model(withExistingParent(name+"-1", mcLoc("item/generated"))
                        .texture("layer0", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-bottle-iron"))
                        .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-handle"))
                        .texture("layer2", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-waterdrip")));

        name = RegItems.GOLD_CANTEEN.getId().getPath();
        withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-bottle-gold"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-handle"))
                .override().predicate(ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "water"), 1f)
                .model(withExistingParent(name+"-1", mcLoc("item/generated"))
                        .texture("layer0", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-bottle-gold"))
                        .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-handle"))
                        .texture("layer2", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-waterdrip")));

        name = RegItems.DIAMOND_CANTEEN.getId().getPath();
        withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-bottle-diamond"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-handle"))
                .override().predicate(ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "water"), 1f)
                .model(withExistingParent(name+"-1", mcLoc("item/generated"))
                        .texture("layer0", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-bottle-diamond"))
                        .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-handle"))
                        .texture("layer2", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-waterdrip")));

        name = RegItems.NETHERITE_CANTEEN.getId().getPath();
        withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-bottle-netherite"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-handle"))
                .override().predicate(ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "water"), 1f)
                .model(withExistingParent(name+"-1", mcLoc("item/generated"))
                        .texture("layer0", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-bottle-netherite"))
                        .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-handle"))
                        .texture("layer2", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-waterdrip")));

        name = RegItems.DRAGON_CANTEEN.getId().getPath();
        withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-bottle-netherite"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-handle"))
                .texture("layer2", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-eye"))
                .override().predicate(ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "water"), 1f)
                .model(withExistingParent(name+"-1", mcLoc("item/generated"))
                        .texture("layer0", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-bottle-netherite"))
                        .texture("layer1", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-handle"))
                        .texture("layer2", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-eye"))
                        .texture("layer3", ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "item/canteen-waterdrip")));
    }

}
