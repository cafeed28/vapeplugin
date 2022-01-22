package com.cafeed28.vapeplugin.types.vapes;

import com.cafeed28.vapeplugin.types.BaseLiquid;
import com.cafeed28.vapeplugin.types.BaseVape;
import com.cafeed28.vapeplugin.types.liquids.EmptyLiquid;

public class JoyetechEGripMini extends BaseVape {
    public JoyetechEGripMini() {
        name = "Joyetech eGrip Mini";
        id = 5;
        price = 19;

        wattage = 13;
        resistance = 0.5f;
        meshcoil = true;

        currentLiquid = (BaseLiquid)new EmptyLiquid();
    }
}