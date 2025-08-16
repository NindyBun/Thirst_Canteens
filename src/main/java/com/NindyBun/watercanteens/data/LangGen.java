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
        add(RegItems.LEATHER_CANTEEN.get(), "Leather Canteen");
        add(RegItems.IRON_CANTEEN.get(), "Iron Canteen");
        add(RegItems.GOLD_CANTEEN.get(), "Gold Canteen");
        add(RegItems.DIAMOND_CANTEEN.get(), "Diamond Canteen");
        add(RegItems.NETHERITE_CANTEEN.get(), "Netherite Canteen");
        add(RegItems.DRAGON_CANTEEN.get(), "Dragon Canteen");
    }
}
