package com.cafeed28.vapeplugin.types.liquids;

import com.cafeed28.vapeplugin.types.BaseLiquid;
import org.bukkit.potion.PotionEffectType;

public class BoshkiOriginal extends BaseLiquid {
    public BoshkiOriginal() {
        name = "Boshki \"Original\"";
        id = 4;
        price = 7;

        colorR = 24;
        colorG = 24;
        colorB = 24;

        maxCapacity = 100;
        currentCapacity = maxCapacity;

        effects.add(PotionEffectType.REGENERATION.getId());
        effectsDuration.add(5);
        effectsAmplifier.add(1);
        effectsOnlyPerfect.add(true);

        effects.add(PotionEffectType.SLOW.getId());
        effectsDuration.add(4);
        effectsAmplifier.add(1);
        effectsOnlyPerfect.add(false);
    }
}