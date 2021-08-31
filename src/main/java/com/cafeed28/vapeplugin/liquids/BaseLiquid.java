package com.cafeed28.vapeplugin.liquids;

import com.cafeed28.vapeplugin.vapes.BaseVape;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class BaseLiquid implements Serializable {
    public String name;
    public int id;
    public int price;

    public int colorR;
    public int colorG;
    public int colorB;

    public float maxCapacity;
    public float currentCapacity;

    public ArrayList<Integer> effects = new ArrayList<>();
    public ArrayList<Integer> effectsDuration = new ArrayList<>();
    public ArrayList<Integer> effectsAmplifier = new ArrayList<>();
    public ArrayList<Boolean> effectsOnlyPerfect = new ArrayList<>();

    public void spendLiquid(int duration, BaseVape vape) {
        currentCapacity -= vape.wattage / (vape.resistance * 150) * duration;
        if (currentCapacity < 0) currentCapacity = 0;
    }
}