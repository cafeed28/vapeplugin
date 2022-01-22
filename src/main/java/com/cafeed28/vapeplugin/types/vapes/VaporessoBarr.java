package com.cafeed28.vapeplugin.types.vapes;

import com.cafeed28.vapeplugin.types.BaseLiquid;
import com.cafeed28.vapeplugin.types.BaseVape;
import com.cafeed28.vapeplugin.types.liquids.EmptyLiquid;

public class VaporessoBarr extends BaseVape {
    public VaporessoBarr() {
        name = "Vaporesso Barr";
        id = 7;
        price = 19;

        wattage = 10;
        resistance = 1.2f;
        meshcoil = true;

        currentLiquid = (BaseLiquid)new EmptyLiquid();
    }
}