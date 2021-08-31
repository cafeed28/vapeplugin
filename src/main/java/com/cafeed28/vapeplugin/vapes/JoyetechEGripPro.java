package com.cafeed28.vapeplugin.vapes;

import com.cafeed28.vapeplugin.liquids.BaseLiquid;
import com.cafeed28.vapeplugin.liquids.EmptyLiquid;

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