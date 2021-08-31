package com.cafeed28.vapeplugin.vapes;

import com.cafeed28.vapeplugin.liquids.BaseLiquid;
import com.cafeed28.vapeplugin.liquids.EmptyLiquid;

public class RincoeMantoAio extends BaseVape {
    public RincoeMantoAio() {
        name = "Rincoe Manto Aio";
        id = 15;
        price = 39;

        wattage = 80;
        resistance = 0.3f;
        meshcoil = true;

        currentLiquid = (BaseLiquid)new EmptyLiquid();
    }
}