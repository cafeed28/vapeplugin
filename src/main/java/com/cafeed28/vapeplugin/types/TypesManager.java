package com.cafeed28.vapeplugin.types;

import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;

public class TypesManager {
    public static ArrayList<BaseVape> vapes;
    public static ArrayList<BaseLiquid> liquids;

    public TypesManager() {
        vapes = new ArrayList<>();
        liquids = new ArrayList<>();

        Set<Class<? extends BaseVape>> vapeReflections = new Reflections("com.cafeed28.vapeplugin.types.vapes")
                .getSubTypesOf(BaseVape.class);

        vapeReflections.forEach(aClass -> {
            try {
                BaseVape c = aClass.getDeclaredConstructor().newInstance();
                vapes.add(c);
            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });

        Collections.sort(vapes, (o1, o2) -> {
            if (o1.id == o2.id)
                return 0;
            return o1.id < o2.id ? -1 : 1;
        });

        Set<Class<? extends BaseLiquid>> liquidReflections = new Reflections("com.cafeed28.vapeplugin.types.liquids")
                .getSubTypesOf(BaseLiquid.class);

        liquidReflections.forEach(aClass -> {
            try {
                BaseLiquid c = aClass.getDeclaredConstructor().newInstance();
                if (c.id != 0) liquids.add(c);
            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });

        Collections.sort(liquids, (o1, o2) -> {
            if (o1.id == o2.id)
                return 0;
            return o1.id < o2.id ? -1 : 1;
        });
    }

    public static BaseVape getVape(String name) {
        return vapes.stream().filter(s -> s.name.equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public static BaseLiquid getLiquid(String name) {
        return liquids.stream().filter(s -> s.name.equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public static ArrayList<BaseVape> getVapes() {
        return vapes;
    }

    public static ArrayList<BaseLiquid> getLiquids() {
        return liquids;
    }
}