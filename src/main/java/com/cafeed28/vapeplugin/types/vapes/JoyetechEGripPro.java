package com.cafeed28.vapeplugin.types.vapes;

import com.cafeed28.vapeplugin.types.BaseLiquid;
import com.cafeed28.vapeplugin.types.BaseVape;
import com.cafeed28.vapeplugin.types.liquids.EmptyLiquid;

public class JoyetechEGripPro extends BaseVape {
    public JoyetechEGripPro() {
        name = "Joyetech eGrip Pro";
        id = 19;
        price = 45;

        wattage = 40;
        resistance = 0.15f;
        meshcoil = true;

        currentLiquid = (BaseLiquid)new EmptyLiquid();
    }
}