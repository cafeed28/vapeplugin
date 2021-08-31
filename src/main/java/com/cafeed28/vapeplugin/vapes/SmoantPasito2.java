package com.cafeed28.vapeplugin.vapes;

import com.cafeed28.vapeplugin.liquids.BaseLiquid;
import com.cafeed28.vapeplugin.liquids.EmptyLiquid;

public class SmoantPasito2 extends BaseVape {
    public SmoantPasito2() {
        name = "Smoant Pasito 2";
        id = 18;
        price = 44;

        wattage = 80;
        resistance = 0.6f;
        meshcoil = true;

        currentLiquid = (BaseLiquid)new EmptyLiquid();
    }
}