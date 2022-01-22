package com.cafeed28.vapeplugin.types.liquids;

import com.cafeed28.vapeplugin.types.BaseLiquid;
import org.bukkit.potion.PotionEffectType;

public class EVACrimsonIce extends BaseLiquid {
    public EVACrimsonIce() {
        name = "E.V.A \"Малиновый лёд\"";
        id = 9;
        price = 8;

        colorR = 64;
        colorG = 45;
        colorB = 134;

        maxCapacity = 50;
        currentCapacity = maxCapacity;

        effects.add(PotionEffectType.SLOW.getId());
        effectsDuration.add(7);
        effectsAmplifier.add(1);
        effectsOnlyPerfect.add(false);
    }
}