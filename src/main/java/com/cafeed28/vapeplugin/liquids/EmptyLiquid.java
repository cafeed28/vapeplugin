package com.cafeed28.vapeplugin.liquids;

public class EmptyLiquid extends BaseLiquid {
    public EmptyLiquid() {
        name = "Пусто";
        id = 0;

        maxCapacity = 0;
        currentCapacity = maxCapacity;
    }
}