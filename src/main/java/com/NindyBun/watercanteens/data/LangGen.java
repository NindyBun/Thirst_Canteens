package com.NindyBun.watercanteens.data;

import com.NindyBun.watercanteens.WaterCanteens;
import com.NindyBun.watercanteens.data.recipies.CanteenCampfireRecipe;
import com.NindyBun.watercanteens.data.recipies.CanteenSmeltingRecipe;
import com.NindyBun.watercanteens.helpers.Utilities;
import com.NindyBun.watercanteens.registries.RegItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.common.data.LanguageProvider;

import java.util.Objects;

public class LangGen extends LanguageProvider {
    public LangGen(PackOutput output, String locale) {
        super(output, WaterCanteens.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        add(Utilities.addModID("itemGroup", "watercanteens_tab"), "Water Canteens");
        add("tooltip."+WaterCanteens.MODID+".dragon-canteen-purity", "Automatically purifies water to acceptable levels.");

        for (int i = 0; i < RegItems.MATERIAL.length; i++) {
            String name = RegItems.MATERIAL[i];
            String cap = name.substring(0, 1).toLowerCase() + name.substring(1);

            add(RegItems.EMPTY_CANTEENS.get(RegItems.MATERIAL[i]).get(), "Empty "+ cap +" Canteen");

            for (int ii = 0; ii < RegItems.PURITY.length; ii++) {
                if (!Objects.equals(RegItems.MATERIAL[i], "dragon")) {
                    add(RegItems.FILLED_CANTEENS.get(RegItems.MATERIAL[i]).get(RegItems.PURITY[ii]).get(), "Filled " + cap + " Canteen");
                } else if (ii >= 2) {
                    add(RegItems.FILLED_CANTEENS.get(RegItems.MATERIAL[i]).get(RegItems.PURITY[ii]).get(), "Filled " + cap + " Canteen");
                }
            }
        }

        /*add(RegItems.EMPTY_LEATHER_CANTEEN.get(), "Empty Leather Canteen");
        add(RegItems.EMPTY_IRON_CANTEEN.get(), "Empty Iron Canteen");
        add(RegItems.EMPTY_COPPER_CANTEEN.get(), "Empty Copper Canteen");
        add(RegItems.EMPTY_GOLD_CANTEEN.get(), "Empty Gold Canteen");
        add(RegItems.EMPTY_DIAMOND_CANTEEN.get(), "Empty Diamond Canteen");
        add(RegItems.EMPTY_NETHERITE_CANTEEN.get(), "Empty Netherite Canteen");
        add(RegItems.EMPTY_DRAGON_CANTEEN.get(), "Empty Dragon Canteen");

        add(RegItems.FILLED_LEATHER_CANTEEN.get(), "Filled Leather Canteen");
        add(RegItems.FILLED_IRON_CANTEEN.get(), "Filled Iron Canteen");
        add(RegItems.FILLED_COPPER_CANTEEN.get(), "Filled Copper Canteen");
        add(RegItems.FILLED_GOLD_CANTEEN.get(), "Filled Gold Canteen");
        add(RegItems.FILLED_DIAMOND_CANTEEN.get(), "Filled Diamond Canteen");
        add(RegItems.FILLED_NETHERITE_CANTEEN.get(), "Filled Netherite Canteen");
        add(RegItems.FILLED_DRAGON_CANTEEN.get(), "Filled Dragon Canteen");*/
    }
}
