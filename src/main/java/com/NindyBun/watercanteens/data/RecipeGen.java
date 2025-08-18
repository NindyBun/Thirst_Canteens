package com.NindyBun.watercanteens.data;

import com.NindyBun.watercanteens.WaterCanteens;
import com.NindyBun.watercanteens.data.recipies.CanteenCampfireRecipe;
import com.NindyBun.watercanteens.data.recipies.CanteenSmeltingRecipe;
import com.NindyBun.watercanteens.registries.RegItems;
import com.NindyBun.watercanteens.registries.RegRecipes;
import dev.ghen.thirst.content.purity.WaterPurity;
import dev.ghen.thirst.content.registry.ThirstComponent;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.internal.NeoForgeItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class RecipeGen extends RecipeProvider {
    Criterion<InventoryChangeTrigger.TriggerInstance> nul = has(Items.AIR);
    public RecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RegItems.EMPTY_LEATHER_CANTEEN.get())
                .pattern("SAS")
                .pattern("A A")
                .pattern("AAA")
                .define('A', Items.LEATHER)
                .define('S', Items.STRING)
                .unlockedBy("", nul)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "leather-canteen"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RegItems.EMPTY_IRON_CANTEEN.get())
                .pattern("AAA")
                .pattern("ASA")
                .pattern("AAA")
                .define('A', Tags.Items.INGOTS_IRON)
                .define('S', RegItems.EMPTY_LEATHER_CANTEEN.get())
                .unlockedBy("", nul)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "leather-iron-canteen"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RegItems.EMPTY_COPPER_CANTEEN.get())
                .pattern("AAA")
                .pattern("ASA")
                .pattern("AAA")
                .define('A', Tags.Items.INGOTS_COPPER)
                .define('S', RegItems.EMPTY_LEATHER_CANTEEN.get())
                .unlockedBy("", nul)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "leather-copper-canteen"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RegItems.EMPTY_GOLD_CANTEEN.get())
                .pattern("AAA")
                .pattern("ASA")
                .pattern("AAA")
                .define('A', Tags.Items.INGOTS_GOLD)
                .define('S', RegItems.EMPTY_IRON_CANTEEN.get())
                .unlockedBy("", nul)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "iron-gold-canteen"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RegItems.EMPTY_GOLD_CANTEEN.get())
                .pattern("AAA")
                .pattern("ASA")
                .pattern("AAA")
                .define('A', Tags.Items.INGOTS_GOLD)
                .define('S', RegItems.EMPTY_COPPER_CANTEEN.get())
                .unlockedBy("", nul)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "copper-gold-canteen"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RegItems.EMPTY_DIAMOND_CANTEEN.get())
                .pattern("AAA")
                .pattern("ASA")
                .pattern("AAA")
                .define('A', Tags.Items.GEMS_DIAMOND)
                .define('S', RegItems.EMPTY_GOLD_CANTEEN.get())
                .unlockedBy("", nul)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "diamond-canteen"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(RegItems.EMPTY_DIAMOND_CANTEEN.get()),
                        Ingredient.of(Tags.Items.INGOTS_NETHERITE),
                        RecipeCategory.TOOLS,
                        RegItems.EMPTY_NETHERITE_CANTEEN.get())
                .unlocks("", nul)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "netherite-canteen"));

        SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(RegItems.EMPTY_NETHERITE_CANTEEN.get()),
                Ingredient.of(Items.CONDUIT),
                Ingredient.of(Items.DRAGON_HEAD),
                RecipeCategory.TOOLS,
                RegItems.EMPTY_DRAGON_CANTEEN.get())
                .unlocks("", nul)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "dragon-canteen"));

        canteenCampfireRecipe(recipeOutput, RegItems.FILLED_LEATHER_CANTEEN.get(), "canteen-leather-campfire");
        canteenCampfireRecipe(recipeOutput, RegItems.FILLED_IRON_CANTEEN.get(), "canteen-iron-campfire");
        canteenCampfireRecipe(recipeOutput, RegItems.FILLED_COPPER_CANTEEN.get(), "canteen-copper-campfire");
        canteenCampfireRecipe(recipeOutput, RegItems.FILLED_GOLD_CANTEEN.get(), "canteen-gold-campfire");
        canteenCampfireRecipe(recipeOutput, RegItems.FILLED_DIAMOND_CANTEEN.get(), "canteen-diamond-campfire");
        canteenCampfireRecipe(recipeOutput, RegItems.FILLED_NETHERITE_CANTEEN.get(), "canteen-netherite-campfire");
        canteenCampfireRecipe(recipeOutput, RegItems.FILLED_DIAMOND_CANTEEN.get(), "canteen-dragon-campfire");

        canteenSmeltingRecipe(recipeOutput, RegItems.FILLED_LEATHER_CANTEEN.get(), "canteen-leather-smelting");
        canteenSmeltingRecipe(recipeOutput, RegItems.FILLED_IRON_CANTEEN.get(), "canteen-iron-smelting");
        canteenSmeltingRecipe(recipeOutput, RegItems.FILLED_COPPER_CANTEEN.get(), "canteen-copper-smelting");
        canteenSmeltingRecipe(recipeOutput, RegItems.FILLED_GOLD_CANTEEN.get(), "canteen-gold-smelting");
        canteenSmeltingRecipe(recipeOutput, RegItems.FILLED_DIAMOND_CANTEEN.get(), "canteen-diamond-smelting");
        canteenSmeltingRecipe(recipeOutput, RegItems.FILLED_NETHERITE_CANTEEN.get(), "canteen-netherite-smelting");
        canteenSmeltingRecipe(recipeOutput, RegItems.FILLED_DIAMOND_CANTEEN.get(), "canteen-dragon-smelting");
    }

    public void canteenCampfireRecipe(RecipeOutput recipeOutput, Item canteen, String name) {
        SimpleCookingRecipeBuilder.generic(
                        Ingredient.of(canteen),
                        RecipeCategory.FOOD,
                        canteen,
                        0.35f, 300,
                        RecipeSerializer.CAMPFIRE_COOKING_RECIPE,
                        CanteenCampfireRecipe::new).unlockedBy("", nul)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, name));
    }

    public void canteenSmeltingRecipe(RecipeOutput recipeOutput, Item canteen, String name) {
        SimpleCookingRecipeBuilder.generic(
                        Ingredient.of(canteen),
                        RecipeCategory.FOOD,
                        canteen,
                        0.35f, 200,
                        RecipeSerializer.SMELTING_RECIPE,
                        CanteenSmeltingRecipe::new).unlockedBy("", nul)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, name));
    }
}
