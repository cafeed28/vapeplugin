package com.cafeed28.vapeplugin;

import com.cafeed28.vapeplugin.commands.*;
import com.cafeed28.vapeplugin.types.TypesManager;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class VapePlugin extends JavaPlugin {

    private static VapePlugin instance;
    public static TypesManager typesManager;

    public static VapePlugin getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        typesManager = new TypesManager();

        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "VapePlugin is enabled!");

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