package com.cafeed28.vapeplugin.liquids;

import org.bukkit.potion.PotionEffectType;

public class BoshkiZimniye extends BaseLiquid {
    public BoshkiZimniye() {
        name = "Boshki \"Зимние\"";
        id = 7;
        price = 7;

        colorR = 118;
        colorG = 162;
        colorB = 179;

        maxCapacity = 100;
        currentCapacity = maxCapacity;

        effects.add(PotionEffectType.REGENERATION.getId());
        effectsDuration.add(10);
        effectsAmplifier.add(1);
        effectsOnlyPerfect.add(true);

        effects.add(PotionEffectType.SLOW.getId());
        effectsDuration.add(7);
        effectsAmplifier.add(1);
        effectsOnlyPerfect.add(false);

        effects.add(PotionEffectType.HEALTH_BOOST.getId());
        effectsDuration.add(30);
        effectsAmplifier.add(0);
        effectsOnlyPerfect.add(true);
    }
}