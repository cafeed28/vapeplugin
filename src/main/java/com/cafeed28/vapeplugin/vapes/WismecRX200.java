package com.cafeed28.vapeplugin.vapes;

import com.cafeed28.vapeplugin.liquids.BaseLiquid;
import com.cafeed28.vapeplugin.liquids.EmptyLiquid;

public class WismecRX200 extends BaseVape {
    public WismecRX200() {
        name = "Wismec RX200";
        id = 25;
        price = 62;

        wattage = 200;
        resistance = 0.6f;
        meshcoil = true;

        currentLiquid = (BaseLiquid)new EmptyLiquid();
    }
}