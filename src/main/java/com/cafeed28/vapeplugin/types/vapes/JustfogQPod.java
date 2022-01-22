package com.cafeed28.vapeplugin.types.vapes;

import com.cafeed28.vapeplugin.types.BaseLiquid;
import com.cafeed28.vapeplugin.types.BaseVape;
import com.cafeed28.vapeplugin.types.liquids.EmptyLiquid;

public class JustfogQPod extends BaseVape {
    public JustfogQPod() {
        name = "Justfog QPod";
        id = 9;
        price = 20;

        wattage = 15;
        resistance = 1.2f;
        meshcoil = false;

        currentLiquid = (BaseLiquid)new EmptyLiquid();
    }
}