package com.cafeed28.vapeplugin.vapes;

import com.cafeed28.vapeplugin.liquids.BaseLiquid;
import com.cafeed28.vapeplugin.liquids.EmptyLiquid;

public class VoopooNavi extends BaseVape {
    public VoopooNavi() {
        name = "Voopoo Navi";
        id = 12;
        price = 26;

        wattage = 40;
        resistance = 0.2f;
        meshcoil = true;

        currentLiquid = (BaseLiquid)new EmptyLiquid();
    }
}