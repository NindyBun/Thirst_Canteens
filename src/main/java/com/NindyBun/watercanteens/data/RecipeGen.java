package com.NindyBun.watercanteens.data;

import com.NindyBun.watercanteens.WaterCanteens;
import com.NindyBun.watercanteens.data.recipies.CanteenCampfireRecipe;
import com.NindyBun.watercanteens.data.recipies.CanteenSmeltingRecipe;
import com.NindyBun.watercanteens.data.recipies.CookingRecipe.CanteenCookingRecipeBuilder;
import com.NindyBun.watercanteens.registries.RegItems;
import dev.ghen.thirst.content.registry.ThirstComponent;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.neoforged.neoforge.common.Tags;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class RecipeGen extends RecipeProvider {
    Criterion<InventoryChangeTrigger.TriggerInstance> nul = has(Items.AIR);
    public RecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RegItems.EMPTY_CANTEENS.get(RegItems.MATERIAL[0]).get())
                .pattern("SAS")
                .pattern("A A")
                .pattern("AAA")
                .define('A', Items.LEATHER)
                .define('S', Items.STRING)
                .unlockedBy("", nul)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "leather-canteen"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RegItems.EMPTY_CANTEENS.get(RegItems.MATERIAL[1]).get())
                .pattern("AAA")
                .pattern("ASA")
                .pattern("AAA")
                .define('A', Tags.Items.INGOTS_IRON)
                .define('S', RegItems.EMPTY_CANTEENS.get(RegItems.MATERIAL[0]).get())
                .unlockedBy("", nul)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "leather-iron-canteen"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RegItems.EMPTY_CANTEENS.get(RegItems.MATERIAL[2]).get())
                .pattern("AAA")
                .pattern("ASA")
                .pattern("AAA")
                .define('A', Tags.Items.INGOTS_COPPER)
                .define('S', RegItems.EMPTY_CANTEENS.get(RegItems.MATERIAL[0]).get())
                .unlockedBy("", nul)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "leather-copper-canteen"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RegItems.EMPTY_CANTEENS.get(RegItems.MATERIAL[3]).get())
                .pattern("AAA")
                .pattern("ASA")
                .pattern("AAA")
                .define('A', Tags.Items.INGOTS_GOLD)
                .define('S', RegItems.EMPTY_CANTEENS.get(RegItems.MATERIAL[1]).get())
                .unlockedBy("", nul)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "iron-gold-canteen"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RegItems.EMPTY_CANTEENS.get(RegItems.MATERIAL[3]).get())
                .pattern("AAA")
                .pattern("ASA")
                .pattern("AAA")
                .define('A', Tags.Items.INGOTS_GOLD)
                .define('S', RegItems.EMPTY_CANTEENS.get(RegItems.MATERIAL[2]).get())
                .unlockedBy("", nul)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "copper-gold-canteen"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RegItems.EMPTY_CANTEENS.get(RegItems.MATERIAL[4]).get())
                .pattern("AAA")
                .pattern("ASA")
                .pattern("AAA")
                .define('A', Tags.Items.GEMS_DIAMOND)
                .define('S', RegItems.EMPTY_CANTEENS.get(RegItems.MATERIAL[3]).get())
                .unlockedBy("", nul)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "diamond-canteen"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(RegItems.EMPTY_CANTEENS.get(RegItems.MATERIAL[4]).get()),
                        Ingredient.of(Tags.Items.INGOTS_NETHERITE),
                        RecipeCategory.TOOLS,
                        RegItems.EMPTY_CANTEENS.get(RegItems.MATERIAL[5]).get())
                .unlocks("", nul)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "netherite-canteen"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(RegItems.EMPTY_CANTEENS.get(RegItems.MATERIAL[5]).get()),
                        Ingredient.of(Items.CONDUIT),
                        Ingredient.of(Items.DRAGON_HEAD),
                        RecipeCategory.TOOLS,
                        RegItems.EMPTY_CANTEENS.get(RegItems.MATERIAL[6]).get())
                .unlocks("", nul)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "dragon-canteen"));

        for (int i = 0; i < RegItems.MATERIAL.length; i++) {
            for (int ii = 0; ii < RegItems.PURITY.length-1; ii++) {
                if (!Objects.equals(RegItems.MATERIAL[i], "dragon")) {
                    SimpleCookingRecipeBuilder.generic(
                                    Ingredient.of(RegItems.FILLED_CANTEENS.get(RegItems.MATERIAL[i]).get(RegItems.PURITY[ii]).get()),
                                    RecipeCategory.FOOD,
                                    RegItems.FILLED_CANTEENS.get(RegItems.MATERIAL[i]).get(RegItems.PURITY[Math.min(ii + 1, 3)]).get(),
                                    0.35f, 300,
                                    RecipeSerializer.CAMPFIRE_COOKING_RECIPE,
                                    CanteenCampfireRecipe::new).unlockedBy("", nul)
                            .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "canteen-" + RegItems.MATERIAL[i] + "-campfire" + "-" + ii + "-" + Math.min(ii + 1, 3)));
                    SimpleCookingRecipeBuilder.generic(
                                    Ingredient.of(RegItems.FILLED_CANTEENS.get(RegItems.MATERIAL[i]).get(RegItems.PURITY[ii]).get()),
                                    RecipeCategory.FOOD,
                                    RegItems.FILLED_CANTEENS.get(RegItems.MATERIAL[i]).get(RegItems.PURITY[Math.min(ii + 2, 3)]).get(),
                                    0.35f, 300,
                                    RecipeSerializer.SMELTING_RECIPE,
                                    CanteenSmeltingRecipe::new).unlockedBy("", nul)
                            .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "canteen-" + RegItems.MATERIAL[i] + "-smelting" + "-" + ii + "-" + Math.min(ii + 2, 3)));
                } else if (ii >= 2) {
                    SimpleCookingRecipeBuilder.generic(
                                    Ingredient.of(RegItems.FILLED_CANTEENS.get(RegItems.MATERIAL[i]).get(RegItems.PURITY[ii]).get()),
                                    RecipeCategory.FOOD,
                                    RegItems.FILLED_CANTEENS.get(RegItems.MATERIAL[i]).get(RegItems.PURITY[Math.min(ii + 1, 3)]).get(),
                                    0.35f, 300,
                                    RecipeSerializer.CAMPFIRE_COOKING_RECIPE,
                                    CanteenCampfireRecipe::new).unlockedBy("", nul)
                            .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "canteen-" + RegItems.MATERIAL[i] + "-campfire" + "-" + ii + "-" + Math.min(ii + 1, 3)));
                    SimpleCookingRecipeBuilder.generic(
                                    Ingredient.of(RegItems.FILLED_CANTEENS.get(RegItems.MATERIAL[i]).get(RegItems.PURITY[ii]).get()),
                                    RecipeCategory.FOOD,
                                    RegItems.FILLED_CANTEENS.get(RegItems.MATERIAL[i]).get(RegItems.PURITY[Math.min(ii + 2, 3)]).get(),
                                    0.35f, 300,
                                    RecipeSerializer.SMELTING_RECIPE,
                                    CanteenSmeltingRecipe::new).unlockedBy("", nul)
                            .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "canteen-" + RegItems.MATERIAL[i] + "-smelting" + "-" + ii + "-" + Math.min(ii + 2, 3)));
                }
            }
        }


        /*ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RegItems.EMPTY_LEATHER_CANTEEN.get())
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
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, "dragon-canteen"));*/

        /*canteenCampfireRecipe(recipeOutput, RegItems.FILLED_LEATHER_CANTEEN.get().getDefaultInstance(), "canteen-leather-campfire");
        canteenCampfireRecipe(recipeOutput, RegItems.FILLED_IRON_CANTEEN.get().getDefaultInstance(), "canteen-iron-campfire");
        canteenCampfireRecipe(recipeOutput, RegItems.FILLED_COPPER_CANTEEN.get().getDefaultInstance(), "canteen-copper-campfire");
        canteenCampfireRecipe(recipeOutput, RegItems.FILLED_GOLD_CANTEEN.get().getDefaultInstance(), "canteen-gold-campfire");
        canteenCampfireRecipe(recipeOutput, RegItems.FILLED_DIAMOND_CANTEEN.get().getDefaultInstance(), "canteen-diamond-campfire");
        canteenCampfireRecipe(recipeOutput, RegItems.FILLED_NETHERITE_CANTEEN.get().getDefaultInstance(), "canteen-netherite-campfire");
        canteenCampfireRecipe(recipeOutput, RegItems.FILLED_DIAMOND_CANTEEN.get().getDefaultInstance(), "canteen-dragon-campfire");

        canteenSmeltingRecipe(recipeOutput, RegItems.FILLED_LEATHER_CANTEEN.get().getDefaultInstance(), "canteen-leather-smelting");
        canteenSmeltingRecipe(recipeOutput, RegItems.FILLED_IRON_CANTEEN.get().getDefaultInstance(), "canteen-iron-smelting");
        canteenSmeltingRecipe(recipeOutput, RegItems.FILLED_COPPER_CANTEEN.get().getDefaultInstance(), "canteen-copper-smelting");
        canteenSmeltingRecipe(recipeOutput, RegItems.FILLED_GOLD_CANTEEN.get().getDefaultInstance(), "canteen-gold-smelting");
        canteenSmeltingRecipe(recipeOutput, RegItems.FILLED_DIAMOND_CANTEEN.get().getDefaultInstance(), "canteen-diamond-smelting");
        canteenSmeltingRecipe(recipeOutput, RegItems.FILLED_NETHERITE_CANTEEN.get().getDefaultInstance(), "canteen-netherite-smelting");
        canteenSmeltingRecipe(recipeOutput, RegItems.FILLED_DIAMOND_CANTEEN.get().getDefaultInstance(), "canteen-dragon-smelting");*/
    }

   public void canteenCampfireRecipe(RecipeOutput recipeOutput, ItemStack canteen, String name) {
        /*ItemStack input = canteen.copy();
        ItemStack result = canteen.copy();
        for (int i = 0; i < 3; i++) {
            input.set(ThirstComponent.PURITY, i);
            result.set(ThirstComponent.PURITY, Math.min(i+1, 3));
            CanteenCookingRecipeBuilder.campfireCooking(
                    input,
                    RecipeCategory.FOOD,
                    result,
                    0.35f,
                    300
            ).unlockedBy("", nul).save(recipeOutput, ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, name+"-"+i+"-"+(i+1)));
        }*/
        SimpleCookingRecipeBuilder.generic(
                        Ingredient.of(canteen),
                        RecipeCategory.FOOD,
                        canteen,
                        0.35f, 300,
                        RecipeSerializer.CAMPFIRE_COOKING_RECIPE,
                        CanteenCampfireRecipe::new).unlockedBy("", nul)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, name));
    }

    public void canteenSmeltingRecipe(RecipeOutput recipeOutput, ItemStack canteen, String name) {
        /*ItemStack input = canteen.copy();
        ItemStack result = canteen.copy();
        for (int i = 0; i < 3; i++) {
            input.set(ThirstComponent.PURITY, i);
            result.set(ThirstComponent.PURITY, Math.min(i+2, 3));
            CanteenCookingRecipeBuilder.smelting(
                    input,
                    RecipeCategory.FOOD,
                    result,
                    0.35f,
                    200
            ).unlockedBy("", nul).save(recipeOutput, ResourceLocation.fromNamespaceAndPath(WaterCanteens.MODID, name+"-"+i+"-"+Math.min(i+2, 3)));
        }*/
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
