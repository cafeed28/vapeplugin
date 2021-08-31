package com.cafeed28.vapeplugin.vapes;

import com.cafeed28.vapeplugin.liquids.BaseLiquid;
import com.cafeed28.vapeplugin.liquids.EmptyLiquid;

public class SmoantPasito extends BaseVape {
    public SmoantPasito() {
        name = "Smoant Pasito";
        id = 8;
        price = 20;

        wattage = 20;
        resistance = 0.6f;
        meshcoil = true;

        currentLiquid = (BaseLiquid)new EmptyLiquid();
    }
}