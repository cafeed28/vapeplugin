package com.cafeed28.vapeplugin.vapes;

import com.cafeed28.vapeplugin.liquids.BaseLiquid;
import com.cafeed28.vapeplugin.liquids.EmptyLiquid;

public class VoopooDragX extends BaseVape {
    public VoopooDragX() {
        name = "Voopoo Drag X";
        id = 21;
        price = 49;

        wattage = 80;
        resistance = 0.15f;
        meshcoil = true;

        currentLiquid = (BaseLiquid)new EmptyLiquid();
    }
}