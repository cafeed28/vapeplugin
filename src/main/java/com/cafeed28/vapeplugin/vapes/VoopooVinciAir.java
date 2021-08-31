package com.cafeed28.vapeplugin.vapes;

import com.cafeed28.vapeplugin.liquids.BaseLiquid;
import com.cafeed28.vapeplugin.liquids.EmptyLiquid;

public class VoopooVinciAir extends BaseVape {
    public VoopooVinciAir() {
        name = "Voopoo Vinci Air";
        id = 16;
        price = 40;

        wattage = 30;
        resistance = 0.6f;
        meshcoil = true;

        currentLiquid = (BaseLiquid)new EmptyLiquid();
    }
}