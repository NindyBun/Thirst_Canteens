package com.NindyBun.watercanteens.data.recipies.CookingRecipe;

import com.NindyBun.watercanteens.registries.RegRecipes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public abstract class CanteenCookingRecipe implements Recipe<SingleRecipeInput> {
    protected final RecipeType<?> type;
    protected final CookingBookCategory category;
    protected final String group;
    protected final ItemStack input;
    protected final ItemStack result;
    protected final float exp;
    protected final int time;

    public CanteenCookingRecipe(RecipeType<?> type, String group, CookingBookCategory category, ItemStack input, ItemStack result, float exp, int time) {
        this.type = type;
        this.category = category;
        this.group = group;
        this.input = input;
        this.result = result;
        this.exp = exp;
        this.time = time;
    }

    @Override
    public boolean matches(SingleRecipeInput singleRecipeInput, Level level) {
        return singleRecipeInput.equals(this.input);
    }

    @Override
    public ItemStack assemble(SingleRecipeInput singleRecipeInput, HolderLookup.Provider provider) {
        return this.result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return this.result;
    }

    public ItemStack getInput() {
        return this.input;
    }

    public float getExp() {
        return this.exp;
    }

    public String getGroup() {
        return this.group;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    public int getCookingTime() {
        return this.time;
    }

    public CookingBookCategory category() {
        return this.category;
    }

    @Override
    public RecipeType<?> getType() {
        return this.type;
    }

    public interface Factory<T extends CanteenCookingRecipe> {
        T create(String var1, CookingBookCategory var2, ItemStack var3, ItemStack var4, float var5, int var6);
    }
}
