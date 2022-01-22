package com.cafeed28.vapeplugin.types.vapes;

import com.cafeed28.vapeplugin.types.BaseLiquid;
import com.cafeed28.vapeplugin.types.BaseVape;
import com.cafeed28.vapeplugin.types.liquids.EmptyLiquid;

public class SmokNovo4 extends BaseVape {
    public SmokNovo4() {
        name = "Smok Novo 4";
        id = 13;
        price = 29;

        wattage = 25;
        resistance = 0.8f;
        meshcoil = true;

        currentLiquid = (BaseLiquid)new EmptyLiquid();
    }
}