package com.NindyBun.watercanteens.data;

import com.NindyBun.watercanteens.WaterCanteens;
import com.NindyBun.watercanteens.helpers.Utilities;
import com.NindyBun.watercanteens.registries.RegItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class LangGen extends LanguageProvider {
    public LangGen(PackOutput output, String locale) {
        super(output, WaterCanteens.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        add(Utilities.addModID("itemGroup", "watercanteens_tab"), "Water Canteens");

        add(RegItems.EMPTY_LEATHER_CANTEEN.get(), "Empty Leather Canteen");
        add(RegItems.EMPTY_IRON_CANTEEN.get(), "Empty Iron Canteen");
        add(RegItems.EMPTY_GOLD_CANTEEN.get(), "Empty Gold Canteen");
        add(RegItems.EMPTY_DIAMOND_CANTEEN.get(), "Empty Diamond Canteen");
        add(RegItems.EMPTY_NETHERITE_CANTEEN.get(), "Empty Netherite Canteen");
        add(RegItems.EMPTY_DRAGON_CANTEEN.get(), "Empty Dragon Canteen");

        add(RegItems.FILLED_LEATHER_CANTEEN.get(), "Filled Leather Canteen");
        add(RegItems.FILLED_IRON_CANTEEN.get(), "Filled Iron Canteen");
        add(RegItems.FILLED_GOLD_CANTEEN.get(), "Filled Gold Canteen");
        add(RegItems.FILLED_DIAMOND_CANTEEN.get(), "Filled Diamond Canteen");
        add(RegItems.FILLED_NETHERITE_CANTEEN.get(), "Filled Netherite Canteen");
        add(RegItems.FILLED_DRAGON_CANTEEN.get(), "Filled Dragon Canteen");
    }
}
