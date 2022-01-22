package com.cafeed28.vapeplugin.types.liquids;

import com.cafeed28.vapeplugin.types.BaseLiquid;
import org.bukkit.potion.PotionEffectType;

public class BoshkiDobriye extends BaseLiquid {
    public BoshkiDobriye() {
        name = "Boshki \"Добрые\"";
        id = 5;
        price = 7;

        colorR = 8;
        colorG = 117;
        colorB = 110;

        maxCapacity = 100;
        currentCapacity = maxCapacity;

        effects.add(PotionEffectType.REGENERATION.getId());
        effectsDuration.add(9);
        effectsAmplifier.add(1);
        effectsOnlyPerfect.add(true);

        effects.add(PotionEffectType.SLOW.getId());
        effectsDuration.add(4);
        effectsAmplifier.add(1);
        effectsOnlyPerfect.add(false);
    }
}