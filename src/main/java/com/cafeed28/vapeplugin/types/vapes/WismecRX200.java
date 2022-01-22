package com.cafeed28.vapeplugin.types.vapes;

import com.cafeed28.vapeplugin.types.BaseLiquid;
import com.cafeed28.vapeplugin.types.BaseVape;
import com.cafeed28.vapeplugin.types.liquids.EmptyLiquid;

public class WismecRX200 extends BaseVape {
    public WismecRX200() {
        name = "Wismec RX200";
        id = 25;
        price = 62;

        wattage = 200;
        resistance = 0.6f;
        meshcoil = false;

        currentLiquid = (BaseLiquid)new EmptyLiquid();
    }
}