package com.cafeed28.vapeplugin.vapes;

import com.cafeed28.vapeplugin.liquids.BaseLiquid;
import com.cafeed28.vapeplugin.liquids.EmptyLiquid;

public class VoopooDragNano extends BaseVape {
    public VoopooDragNano() {
        name = "Voopoo DRAG Nano";
        id = 4;
        price = 16;

        wattage = 15;
        resistance = 0.7f;
        meshcoil = true;

        currentLiquid = (BaseLiquid)new EmptyLiquid();
    }
}