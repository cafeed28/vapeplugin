package com.cafeed28.vapeplugin.liquids;

import org.bukkit.potion.PotionEffectType;

public class EVATropicalFruits extends BaseLiquid {
    public EVATropicalFruits() {
        name = "E.V.A \"Тропические фрукты\"";
        id = 8;
        price = 8;

        colorR = 53;
        colorG = 211;
        colorB = 47;

        maxCapacity = 50;
        currentCapacity = maxCapacity;

        effects.add(PotionEffectType.SLOW.getId());
        effectsDuration.add(7);
        effectsAmplifier.add(1);
        effectsOnlyPerfect.add(false);
    }
}