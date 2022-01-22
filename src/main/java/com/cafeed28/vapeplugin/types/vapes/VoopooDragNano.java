package com.cafeed28.vapeplugin.types.vapes;

import com.cafeed28.vapeplugin.types.BaseLiquid;
import com.cafeed28.vapeplugin.types.BaseVape;
import com.cafeed28.vapeplugin.types.liquids.EmptyLiquid;

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