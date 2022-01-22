package com.cafeed28.vapeplugin.types.vapes;

import com.cafeed28.vapeplugin.types.BaseLiquid;
import com.cafeed28.vapeplugin.types.BaseVape;
import com.cafeed28.vapeplugin.types.liquids.EmptyLiquid;

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