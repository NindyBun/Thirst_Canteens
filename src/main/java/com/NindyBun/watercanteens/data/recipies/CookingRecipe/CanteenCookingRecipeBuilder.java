package com.NindyBun.watercanteens.data.recipies.CookingRecipe;

import com.NindyBun.watercanteens.data.recipies.CanteenCampfireRecipe;
import com.NindyBun.watercanteens.data.recipies.CanteenSmeltingRecipe;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import org.checkerframework.framework.qual.Unused;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class CanteenCookingRecipeBuilder implements RecipeBuilder {
    private final RecipeCategory category;
    private final CookingBookCategory bookCategory;
    private final ItemStack result;
    private final ItemStack input;
    private final float experience;
    private final int cookingTime;
    private final Map<String, Criterion<?>> criteria;
    @javax.annotation.Nullable
    private String group;
    private final CanteenCookingRecipe.Factory<?> factory;

    public CanteenCookingRecipeBuilder(RecipeCategory category, CookingBookCategory bookCategory, ItemStack result, ItemStack input, float experience, int cookingTime, CanteenCookingRecipe.Factory<?> factory) {
        this.category = category;
        this.bookCategory = bookCategory;
        this.result = result;
        this.input = input;
        this.experience = experience;
        this.cookingTime = cookingTime;
        this.criteria = new LinkedHashMap<>();
        this.factory = factory;
    }

//    public static CanteenCookingRecipeBuilder campfireCooking(ItemStack ingredient, RecipeCategory category, ItemStack result, float experience, int cookingTime) {
//        return new CanteenCookingRecipeBuilder(category, CookingBookCategory.FOOD, result, ingredient, experience, cookingTime, CanteenCampfireRecipe::new);
//    }
//
//    public static CanteenCookingRecipeBuilder smelting(ItemStack ingredient, RecipeCategory category, ItemStack result, float experience, int cookingTime) {
//        return new CanteenCookingRecipeBuilder(category, CookingBookCategory.FOOD, result, ingredient, experience, cookingTime, CanteenSmeltingRecipe::new);
//    }

    @Override
    public RecipeBuilder unlockedBy(String s, Criterion<?> criterion) {
        this.criteria.put(s, criterion);
        return this;
    }

    @Override
    public RecipeBuilder group(@Nullable String s) {
        this.group = s;
        return this;
    }

    @Override
    public Item getResult() {
        return this.result.getItem();
    }

    @Override
    public void save(RecipeOutput recipeOutput, ResourceLocation resourceLocation) {
        this.ensureValid(resourceLocation);
        Advancement.Builder advancementBuilder = recipeOutput.advancement().addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(resourceLocation)).rewards(AdvancementRewards.Builder.recipe(resourceLocation)).requirements(AdvancementRequirements.Strategy.OR);
        Map<String, Criterion<?>> var10000 = this.criteria;
        var10000.forEach(advancementBuilder::addCriterion);
        CanteenCookingRecipe recipe = this.factory.create((String)Objects.requireNonNullElse(this.group, ""), this.bookCategory, this.input, this.result, this.experience, this.cookingTime);
        recipeOutput.accept(resourceLocation, recipe, advancementBuilder.build(resourceLocation.withPrefix("recipes/" + this.category.getFolderName() + "/")));
    }

    private void ensureValid(ResourceLocation id) {
        if (this.criteria.isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + String.valueOf(id));
        }
    }
}
