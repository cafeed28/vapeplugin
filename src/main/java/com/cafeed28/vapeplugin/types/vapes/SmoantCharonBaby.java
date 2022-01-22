package com.cafeed28.vapeplugin.types.vapes;

import com.cafeed28.vapeplugin.types.BaseLiquid;
import com.cafeed28.vapeplugin.types.BaseVape;
import com.cafeed28.vapeplugin.types.liquids.EmptyLiquid;

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