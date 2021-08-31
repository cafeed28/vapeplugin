package com.cafeed28.vapeplugin.liquids;

import org.bukkit.potion.PotionEffectType;

public class BruskoVanillaTobacco extends BaseLiquid {
    public BruskoVanillaTobacco() {
        name = "Brusko \"Ванильный табак\"";
        id = 1;
        price = 5;

        colorR = 237;
        colorG = 143;
        colorB = 56;

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