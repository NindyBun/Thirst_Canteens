package com.NindyBun.watercanteens.registries;

import com.NindyBun.watercanteens.WaterCanteens;
import com.NindyBun.watercanteens.data.recipies.CanteenCampfireRecipe;
import com.NindyBun.watercanteens.data.recipies.CanteenSmeltingRecipe;
import com.NindyBun.watercanteens.data.recipies.CookingRecipe.CanteenCookingSerializer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.*;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class RegRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPES = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, WaterCanteens.MODID);

//    public static final DeferredHolder<RecipeSerializer<?>, CanteenCookingSerializer<CanteenCampfireRecipe>> CANTEEN_CAMPFIRE_RECIPE = RECIPES.register("canteen-campfire-recipe", () -> new CanteenCookingSerializer<>(CanteenCampfireRecipe::new, 100));
//    public static final DeferredHolder<RecipeSerializer<?>, CanteenCookingSerializer<CanteenSmeltingRecipe>> CANTEEN_SMELTING_RECIPE = RECIPES.register("canteen-smelting-recipe", () -> new CanteenCookingSerializer<>(CanteenSmeltingRecipe::new, 100));

    public static final DeferredHolder<RecipeSerializer<?>, SimpleCookingSerializer<CanteenCampfireRecipe>> CANTEEN_CAMPFIRE_RECIPE = RECIPES.register("canteen-campfire-recipe", () -> new SimpleCookingSerializer<>(CanteenCampfireRecipe::new, 100));
    public static final DeferredHolder<RecipeSerializer<?>, SimpleCookingSerializer<CanteenSmeltingRecipe>> CANTEEN_SMELTING_RECIPE = RECIPES.register("canteen-smelting-recipe", () -> new SimpleCookingSerializer<>(CanteenSmeltingRecipe::new, 100));

}
