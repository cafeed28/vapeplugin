package com.cafeed28.vapeplugin.vapes;

import com.cafeed28.vapeplugin.liquids.BaseLiquid;
import com.cafeed28.vapeplugin.liquids.EmptyLiquid;

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