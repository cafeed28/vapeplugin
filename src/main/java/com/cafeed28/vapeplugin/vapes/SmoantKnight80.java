package com.cafeed28.vapeplugin.vapes;

import com.cafeed28.vapeplugin.liquids.BaseLiquid;
import com.cafeed28.vapeplugin.liquids.EmptyLiquid;

public class SmoantKnight80 extends BaseVape {
    public SmoantKnight80() {
        name = "Smoant Knight 80";
        id = 17;
        price = 42;

        wattage = 80;
        resistance = 0.3f;
        meshcoil = true;

        currentLiquid = (BaseLiquid)new EmptyLiquid();
    }
}