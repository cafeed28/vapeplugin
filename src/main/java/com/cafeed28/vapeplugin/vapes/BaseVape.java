package com.cafeed28.vapeplugin.vapes;

import com.cafeed28.vapeplugin.liquids.BaseLiquid;

import java.io.Serializable;

public abstract class BaseVape implements Serializable {
    public String name;
    public int id;
    public int price;

    public int wattage;
    public float resistance;
    public boolean meshcoil;
    public BaseLiquid currentLiquid;

    public int getMaxHoldTime() {
        float x = meshcoil ? 0.75f : 1;
        return Math.round(10 / wattage * 10 * x) * 1000;
    }

    public int getParticlesCount() {
        return Math.round(wattage / resistance);
    }
}