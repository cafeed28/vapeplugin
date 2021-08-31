package com.cafeed28.vapeplugin.vapes;

import com.cafeed28.vapeplugin.liquids.BaseLiquid;
import com.cafeed28.vapeplugin.liquids.EmptyLiquid;

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