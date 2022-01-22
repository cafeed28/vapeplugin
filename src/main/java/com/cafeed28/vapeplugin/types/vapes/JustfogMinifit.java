package com.cafeed28.vapeplugin.types.vapes;

import com.cafeed28.vapeplugin.types.BaseLiquid;
import com.cafeed28.vapeplugin.types.BaseVape;
import com.cafeed28.vapeplugin.types.liquids.EmptyLiquid;

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