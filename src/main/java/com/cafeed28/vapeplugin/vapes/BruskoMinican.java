package com.cafeed28.vapeplugin.vapes;

import com.cafeed28.vapeplugin.liquids.BaseLiquid;
import com.cafeed28.vapeplugin.liquids.EmptyLiquid;

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