package com.cafeed28.vapeplugin.types.vapes;

import com.cafeed28.vapeplugin.types.BaseLiquid;
import com.cafeed28.vapeplugin.types.BaseVape;
import com.cafeed28.vapeplugin.types.liquids.EmptyLiquid;

public class BruskoMinican extends BaseVape {
    public BruskoMinican() {
        name = "Brusko Minican";
        id = 2;
        price = 12;

        wattage = 5;
        resistance = 1.0f;
        meshcoil = false;

        currentLiquid = (BaseLiquid)new EmptyLiquid();
    }
}