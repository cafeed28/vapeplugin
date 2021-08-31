package com.cafeed28.vapeplugin.vapes;

import com.cafeed28.vapeplugin.liquids.BaseLiquid;
import com.cafeed28.vapeplugin.liquids.EmptyLiquid;

public class Juul extends BaseVape {
    public Juul() {
        name = "JUUL";
        id = 3;
        price = 14;

        wattage = 8;
        resistance = 1.5f;
        meshcoil = true;

        currentLiquid = (BaseLiquid)new EmptyLiquid();
    }
}