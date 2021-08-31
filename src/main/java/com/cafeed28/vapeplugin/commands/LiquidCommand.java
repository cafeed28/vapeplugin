package com.cafeed28.vapeplugin.commands;

import com.cafeed28.vapeplugin.LiquidItem;
import com.cafeed28.vapeplugin.VapePlugin;
import com.cafeed28.vapeplugin.liquids.BaseLiquid;
import com.cafeed28.vapeplugin.liquids.EmptyLiquid;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static java.util.stream.Collectors.joining;

public class LiquidCommand implements CommandExecutor {
    public final ArrayList<BaseLiquid> liquidTypes;

    public LiquidCommand() {
        liquidTypes = VapePlugin.getInstance().liquids;
    }

    @Override
    public boolean onCommand(CommandSender s, Command command, String label, String[] args) {
        if (!(s instanceof Player)) {
            s.sendMessage("[VapePlugin] Консоль не может использовать эту команду!");
            return true;
        }

        HashMap<Integer, String> liquids = new HashMap<>();

        for (BaseLiquid liquid : liquidTypes) liquids.put(liquid.id, liquid.name);

        String liquidsList = liquids.entrySet()
                .stream()
                .map(e -> e.getKey() + ": " + e.getValue())
                .collect(joining("\n"));

        if (args.length == 0) {
            s.sendMessage("[VapePlugin] Введи айди жижи. Доступные жижи:\n"
                    + liquidsList);
            return false;
        }

        String liquidId = args[0];
        BaseLiquid liquid = null;

        for (BaseLiquid liquidType : liquidTypes) {
            int id = Integer.parseInt(liquidId);
            if (id == liquidType.id) {
                liquid = liquidType;
                break;
            }
        }

        if (liquid == null) {
            s.sendMessage("[VapePlugin] Нет такой жижи. Доступные жижи:\n"
                    + liquidsList);
            return false;
        }

        Player p = (Player) s;
        try {
            p.getInventory().addItem(LiquidItem.getLiquidItem(liquid));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }
}