package com.NindyBun.watercanteens.data.recipies;

import com.NindyBun.watercanteens.WaterCanteens;
import com.NindyBun.watercanteens.data.recipies.CookingRecipe.CanteenCookingRecipe;
import com.NindyBun.watercanteens.items.FilledCanteen;
import com.NindyBun.watercanteens.registries.RegRecipes;
import dev.ghen.thirst.content.registry.ThirstComponent;
import mezz.jei.api.gui.builder.IIngredientAcceptor;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;

public class CanteenCampfireRecipe extends CampfireCookingRecipe {
    /*public CanteenCampfireRecipe(String group, CookingBookCategory category, ItemStack ingredient, ItemStack result, float exp, int time) {
        super(RecipeType.CAMPFIRE_COOKING, group, category, ingredient, result, exp, time);
    }*/

    public CanteenCampfireRecipe(String group, CookingBookCategory category, Ingredient ingredient, ItemStack result, float exp, int time) {
        super(group, category, ingredient, result, exp, time);
    }

    @Override
    public ItemStack assemble(SingleRecipeInput input, HolderLookup.Provider registries) {
        ItemStack stack = input.item();
        if(stack.get(ThirstComponent.PURITY)==null){
            if(stack.getItem() instanceof FilledCanteen canteen)
                stack.set(ThirstComponent.PURITY,canteen.getCanteenTier().getPurity());
        }

        int purity = Math.min(stack.get(ThirstComponent.PURITY)+1,3);
        ItemStack result = this.result.copy();
        result.set(ThirstComponent.PURITY, purity);

        return result;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RegRecipes.CANTEEN_CAMPFIRE_RECIPE.get();
    }


}
