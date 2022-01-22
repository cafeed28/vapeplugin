package com.cafeed28.vapeplugin.types.vapes;

import com.cafeed28.vapeplugin.types.BaseLiquid;
import com.cafeed28.vapeplugin.types.BaseVape;
import com.cafeed28.vapeplugin.types.liquids.EmptyLiquid;

public class SmoantBattlestarBaby extends BaseVape {
    public SmoantBattlestarBaby() {
        name = "Smoant Battlestar Baby";
        id = 11;
        price = 23;

        wattage = 15;
        resistance = 0.6f;
        meshcoil = true;

        currentLiquid = (BaseLiquid)new EmptyLiquid();
    }
}