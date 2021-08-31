package com.cafeed28.vapeplugin.vapes;

import com.cafeed28.vapeplugin.liquids.BaseLiquid;
import com.cafeed28.vapeplugin.liquids.EmptyLiquid;

public class JustfogMinifit extends BaseVape {
    public JustfogMinifit() {
        name = "Justfog Minifit";
        id = 1;
        price = 10;

        wattage = 7;
        resistance = 1.2f;
        meshcoil = true;

        currentLiquid = (BaseLiquid)new EmptyLiquid();
    }
}