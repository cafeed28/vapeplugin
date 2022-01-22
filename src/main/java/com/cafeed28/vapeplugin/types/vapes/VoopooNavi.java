package com.cafeed28.vapeplugin.types.vapes;

import com.cafeed28.vapeplugin.types.BaseLiquid;
import com.cafeed28.vapeplugin.types.BaseVape;
import com.cafeed28.vapeplugin.types.liquids.EmptyLiquid;

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