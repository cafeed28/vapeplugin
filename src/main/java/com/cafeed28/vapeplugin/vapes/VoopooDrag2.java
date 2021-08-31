package com.cafeed28.vapeplugin.vapes;

import com.cafeed28.vapeplugin.liquids.BaseLiquid;
import com.cafeed28.vapeplugin.liquids.EmptyLiquid;

public class VoopooDrag2 extends BaseVape {
    public VoopooDrag2() {
        name = "Voopoo Drag 2";
        id = 24;
        price = 60;

        wattage = 177;
        resistance = 0.15f;
        meshcoil = true;

        currentLiquid = (BaseLiquid)new EmptyLiquid();
    }
}