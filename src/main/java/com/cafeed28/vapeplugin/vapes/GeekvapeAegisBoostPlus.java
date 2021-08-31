package com.cafeed28.vapeplugin.vapes;

import com.cafeed28.vapeplugin.liquids.BaseLiquid;
import com.cafeed28.vapeplugin.liquids.EmptyLiquid;

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