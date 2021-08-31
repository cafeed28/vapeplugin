package com.cafeed28.vapeplugin.commands;

import com.cafeed28.vapeplugin.LiquidItem;
import com.cafeed28.vapeplugin.VapeItem;
import com.cafeed28.vapeplugin.VapePlugin;
import com.cafeed28.vapeplugin.liquids.BaseLiquid;
import com.cafeed28.vapeplugin.liquids.EmptyLiquid;
import com.cafeed28.vapeplugin.vapes.BaseVape;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;
import java.util.ArrayList;

public class ShopCommand implements CommandExecutor {
    public final ArrayList<BaseVape> vapeTypes;
    public final ArrayList<BaseLiquid> liquidTypes;

    public ShopCommand() {
        vapeTypes = VapePlugin.getInstance().vapes;
        liquidTypes = VapePlugin.getInstance().liquids;
    }

    @Override
    public boolean onCommand(CommandSender s, Command command, String label, String[] args) {
        if (!(s instanceof Player)) {
            s.sendMessage("[VapePlugin] Консоль не может использовать эту команду!");
            return true;
        }

        if (args.length < 1) {
            s.sendMessage("[VapePlugin] Укажи тип магазина (vape/liquid)");
            return false;
        }

        Player p = (Player) s;

        String title = "Вейп-шоп)";
        String type = args[0];

        ArrayList<ItemStack> items = new ArrayList<>();

        if (type.equals("vape")) {
            title += " : вейпы";
            for (BaseVape vape : vapeTypes) {
                try {
                    items.add(VapeItem.getVapeItem(vape));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else if (type.equals("liquid")) {
            title += " : жижи";
            for (BaseLiquid liquid : liquidTypes) {
                try {
                    items.add(LiquidItem.getLiquidItem(liquid));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            s.sendMessage("[VapePlugin] Укажи правильный тип магазина! Доступны: vape/liquid");
            return false;
        }

        Inventory inventory = Bukkit.createInventory(null, 27, title);

        for (ItemStack item : items) inventory.addItem(item);

        p.openInventory(inventory);

        return true;
    }
}