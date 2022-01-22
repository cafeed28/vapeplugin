package com.cafeed28.vapeplugin.types.liquids;

import com.cafeed28.vapeplugin.types.BaseLiquid;

public class EmptyLiquid extends BaseLiquid {
    public EmptyLiquid() {
        name = "Пусто";
        id = 0;

        maxCapacity = 0;
        currentCapacity = maxCapacity;
    }
}