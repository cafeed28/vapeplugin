package com.cafeed28.vapeplugin.types.vapes;

import com.cafeed28.vapeplugin.types.BaseLiquid;
import com.cafeed28.vapeplugin.types.BaseVape;
import com.cafeed28.vapeplugin.types.liquids.EmptyLiquid;

public class VoopooDragS extends BaseVape {
    public VoopooDragS() {
        name = "Voopoo Drag S";
        id = 22;
        price = 50;

        wattage = 60;
        resistance = 0.2f;
        meshcoil = true;

        currentLiquid = (BaseLiquid)new EmptyLiquid();
    }
}