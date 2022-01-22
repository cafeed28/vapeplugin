package com.cafeed28.vapeplugin.types.liquids;

import com.cafeed28.vapeplugin.types.BaseLiquid;
import org.bukkit.potion.PotionEffectType;

public class IllusionVitamin extends BaseLiquid {
    public IllusionVitamin() {
        name = "Illusion \"Vitamin\"";
        id = 10;

        colorR = 153;
        colorG = 209;
        colorB = 100;

        maxCapacity = 115;
        currentCapacity = maxCapacity;

        effects.add(PotionEffectType.REGENERATION.getId());
        effectsDuration.add(3);
        effectsAmplifier.add(1);
        effectsOnlyPerfect.add(true);

        effects.add(PotionEffectType.SLOW.getId());
        effectsDuration.add(4);
        effectsAmplifier.add(1);
        effectsOnlyPerfect.add(false);

        effects.add(PotionEffectType.HEALTH_BOOST.getId());
        effectsDuration.add(17);
        effectsAmplifier.add(0);
        effectsOnlyPerfect.add(false);
    }
}