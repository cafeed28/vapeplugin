package com.cafeed28.vapeplugin.liquids;

import org.bukkit.potion.PotionEffectType;

public class BoshkiZlyie extends BaseLiquid {
    public BoshkiZlyie() {
        name = "Boshki \"Злые\"";
        id = 6;
        price = 7;

        colorR = 15;
        colorG = 199;
        colorB = 83;

        maxCapacity = 100;
        currentCapacity = maxCapacity;

        effects.add(PotionEffectType.REGENERATION.getId());
        effectsDuration.add(7);
        effectsAmplifier.add(1);
        effectsOnlyPerfect.add(true);

        effects.add(PotionEffectType.SLOW.getId());
        effectsDuration.add(5);
        effectsAmplifier.add(1);
        effectsOnlyPerfect.add(false);
    }
}