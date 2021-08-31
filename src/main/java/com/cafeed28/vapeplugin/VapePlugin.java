package com.cafeed28.vapeplugin;

import com.cafeed28.vapeplugin.commands.*;
import com.cafeed28.vapeplugin.liquids.*;
import com.cafeed28.vapeplugin.vapes.*;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class VapePlugin extends JavaPlugin {
    public final ArrayList<BaseVape> vapes = new ArrayList<>();
    public final ArrayList<BaseLiquid> liquids = new ArrayList<>();

    private static VapePlugin instance;

    public static VapePlugin getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "VapePlugin is enabled!");

        // initializing vapes
        vapes.add(new JustfogMinifit());
        vapes.add(new BruskoMinican());
        vapes.add(new Juul());
        vapes.add(new VoopooDragNano());
        vapes.add(new JoyetechEGripMini());
        vapes.add(new SuorinAir());
        vapes.add(new VaporessoBarr());
        vapes.add(new SmoantPasito());
        vapes.add(new JustfogQPod());
        vapes.add(new SmoantCharonBaby());
        vapes.add(new SmoantBattlestarBaby());
        vapes.add(new VoopooNavi());
        vapes.add(new SmokNovo4());
        vapes.add(new SmokNordX());
        vapes.add(new RincoeMantoAio());
        vapes.add(new VoopooVinciAir());
        vapes.add(new SmoantKnight80());
        vapes.add(new SmoantPasito2());
        vapes.add(new JoyetechEGripPro());
        vapes.add(new GeekvapeAegisBoost());
        vapes.add(new VoopooDragX());
        vapes.add(new VoopooDragS());
        vapes.add(new GeekvapeAegisBoostPlus());
        vapes.add(new VoopooDrag2());
        vapes.add(new WismecRX200());

        // initializing liquids
        liquids.add(new BruskoVanillaTobacco());
        liquids.add(new BruskoEnergy());
        liquids.add(new BruskoMentol());
        liquids.add(new BoshkiOriginal());
        liquids.add(new BoshkiDobriye());
        liquids.add(new BoshkiZlyie());
        liquids.add(new BoshkiZimniye());
        liquids.add(new EVATropicalFruits());
        liquids.add(new EVACrimsonIce());
        liquids.add(new IllusionVitamin());
        liquids.add(new IllusionGelato());

        getServer().getPluginManager().registerEvents(new VapeItem(), this);
        getServer().getPluginManager().registerEvents(new ShopManager(), this);

        getCommand("vape").setExecutor(new VapeCommand());
        getCommand("liquid").setExecutor(new LiquidCommand());
        getCommand("fill").setExecutor(new FillCommand());
        getCommand("shop").setExecutor(new ShopCommand());
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "VapePlugin is disabled");

        instance = null;
    }
}