package com.cafeed28.vapeplugin.liquids;

import org.bukkit.potion.PotionEffectType;

public class BruskoEnergy extends BaseLiquid {
    public BruskoEnergy() {
        name = "Brusko \"Энергетик\"";
        id = 2;
        price = 5;

        colorR = 185;
        colorG = 86;
        colorB = 150;

        maxCapacity = 30;
        currentCapacity = maxCapacity;

        effects.add(PotionEffectType.POISON.getId());
        effectsDuration.add(3);
        effectsAmplifier.add(1);
        effectsOnlyPerfect.add(true);

        effects.add(PotionEffectType.SLOW.getId());
        effectsDuration.add(7);
        effectsAmplifier.add(1);
        effectsOnlyPerfect.add(false);
    }
}