package com.cafeed28.vapeplugin.liquids;

import org.bukkit.potion.PotionEffectType;

public class BruskoMentol extends BaseLiquid {
    public BruskoMentol() {
        name = "Brusko \"Ментол\"";
        id = 3;
        price = 5;

        colorR = 1;
        colorG = 204;
        colorB = 235;

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