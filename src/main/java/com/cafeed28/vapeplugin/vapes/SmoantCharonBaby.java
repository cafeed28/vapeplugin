package com.cafeed28.vapeplugin.vapes;

import com.cafeed28.vapeplugin.liquids.BaseLiquid;
import com.cafeed28.vapeplugin.liquids.EmptyLiquid;

public class SmoantCharonBaby extends BaseVape {
    public SmoantCharonBaby() {
        name = "Smoant Charon Baby";
        id = 10;
        price = 22;

        wattage = 15;
        resistance = 0.6f;
        meshcoil = true;

        currentLiquid = (BaseLiquid)new EmptyLiquid();
    }
}