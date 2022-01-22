package com.cafeed28.vapeplugin.types.liquids;

import com.cafeed28.vapeplugin.types.BaseLiquid;
import org.bukkit.potion.PotionEffectType;

public class IllusionGelato extends BaseLiquid {
    public IllusionGelato() {
        name = "Illusion \"Gelato\"";
        id = 11;
        price = 13;

        colorR = 224;
        colorG = 215;
        colorB = 84;

        maxCapacity = 115;
        currentCapacity = maxCapacity;

        effects.add(PotionEffectType.REGENERATION.getId());
        effectsDuration.add(3);
        effectsAmplifier.add(1);
        effectsOnlyPerfect.add(true);

        effects.add(PotionEffectType.SLOW.getId());
        effectsDuration.add(2);
        effectsAmplifier.add(1);
        effectsOnlyPerfect.add(false);
    }
}