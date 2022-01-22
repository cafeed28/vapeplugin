package com.cafeed28.vapeplugin.types.vapes;

import com.cafeed28.vapeplugin.types.BaseLiquid;
import com.cafeed28.vapeplugin.types.BaseVape;
import com.cafeed28.vapeplugin.types.liquids.EmptyLiquid;

public class GeekvapeAegisBoostPlus extends BaseVape {
    public GeekvapeAegisBoostPlus() {
        name = "Geekvape Aegis Boost Plus";
        id = 23;
        price = 53;

        wattage = 40;
        resistance = 0.2f;
        meshcoil = true;

        currentLiquid = (BaseLiquid)new EmptyLiquid();
    }
}