package com.cafeed28.vapeplugin.types.vapes;

import com.cafeed28.vapeplugin.types.BaseLiquid;
import com.cafeed28.vapeplugin.types.BaseVape;
import com.cafeed28.vapeplugin.types.liquids.EmptyLiquid;

public class SuorinAir extends BaseVape {
    public SuorinAir() {
        name = "Suorin Air";
        id = 6;
        price = 19;

        wattage = 16;
        resistance = 0.6f;
        meshcoil = true;

        currentLiquid = (BaseLiquid)new EmptyLiquid();
    }
}