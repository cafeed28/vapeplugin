package com.cafeed28.vapeplugin.vapes;

import com.cafeed28.vapeplugin.liquids.BaseLiquid;
import com.cafeed28.vapeplugin.liquids.EmptyLiquid;

public class GeekvapeAegisBoost extends BaseVape {
    public GeekvapeAegisBoost() {
        name = "Geekvape Aegis Boost";
        id = 20;
        price = 46;

        wattage = 40;
        resistance = 0.6f;
        meshcoil = true;

        currentLiquid = (BaseLiquid)new EmptyLiquid();
    }
}