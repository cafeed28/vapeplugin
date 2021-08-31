package com.cafeed28.vapeplugin.commands;

import com.cafeed28.vapeplugin.VapeItem;
import com.cafeed28.vapeplugin.VapePlugin;
import com.cafeed28.vapeplugin.vapes.BaseVape;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static java.util.stream.Collectors.joining;

public class VapeCommand implements CommandExecutor {
    public final ArrayList<BaseVape> vapeTypes;

    public VapeCommand() {
        vapeTypes = VapePlugin.getInstance().vapes;
    }

    @Override
    public boolean onCommand(CommandSender s, Command command, String label, String[] args) {
        if (!(s instanceof Player)) {
            s.sendMessage("[VapePlugin] Консоль не может использовать эту команду!");
            return true;
        }

        HashMap<Integer, String> vapes = new HashMap<>();

        for (BaseVape vape : vapeTypes) vapes.put(vape.id, vape.name);

        String vapesList = vapes.entrySet()
                .stream()
                .map(e -> e.getKey() + ": " + e.getValue())
                .collect(joining("\n"));

        if (args.length == 0) {
            s.sendMessage("[VapePlugin] Введи айди вейпа. Доступные вейпы:\n"
                    + vapesList);
            return false;
        }

        String vapeId = args[0];
        BaseVape vape = null;

        for (BaseVape vapeType : vapeTypes) {
            int id = Integer.parseInt(vapeId);
            if (id == vapeType.id) {
                vape = vapeType;
                break;
            }
        }

        if (vape == null) {
            s.sendMessage("[VapePlugin] Нет такого вейпа. Доступные вейпы:\n"
                    + vapesList);
            return false;
        }

        Player p = (Player) s;
        try {
            p.getInventory().addItem(VapeItem.getVapeItem(vape));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }
}