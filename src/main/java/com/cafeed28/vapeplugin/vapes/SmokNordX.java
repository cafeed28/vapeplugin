package com.cafeed28.vapeplugin.vapes;

import com.cafeed28.vapeplugin.liquids.BaseLiquid;
import com.cafeed28.vapeplugin.liquids.EmptyLiquid;

public class SmokNordX extends BaseVape {
    public SmokNordX() {
        name = "Smok Nord X";
        id = 14;
        price = 34;

        wattage = 60;
        resistance = 0.6f;
        meshcoil = true;

        currentLiquid = (BaseLiquid)new EmptyLiquid();
    }
}