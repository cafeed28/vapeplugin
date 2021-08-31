package com.cafeed28.vapeplugin.commands;

import com.cafeed28.vapeplugin.Utils;
import com.cafeed28.vapeplugin.VapeItem;
import com.cafeed28.vapeplugin.VapePlugin;
import com.cafeed28.vapeplugin.liquids.BaseLiquid;
import com.cafeed28.vapeplugin.liquids.EmptyLiquid;
import com.cafeed28.vapeplugin.vapes.BaseVape;
import net.minecraft.server.v1_16_R3.NBTTagCompound;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

import static com.cafeed28.vapeplugin.Utils.*;
import static java.util.stream.Collectors.joining;

public class FillCommand implements CommandExecutor {
    public final ArrayList<BaseVape> vapeTypes;
    public final ArrayList<BaseLiquid> liquidTypes;

    public FillCommand() {
        vapeTypes = VapePlugin.getInstance().vapes;
        liquidTypes = VapePlugin.getInstance().liquids;
    }

    @Override
    public boolean onCommand(CommandSender s, Command command, String label, String[] args) {
        if (!(s instanceof Player)) {
            s.sendMessage("[VapePlugin] Консоль не может использовать эту команду!");
            return true;
        }

        if (args.length == 0) {
            s.sendMessage("[VapePlugin] Возьми вейп в руки и введи айди жижи, которая у тебя есть");
            return false;
        }

        Player p = (Player) s;
        ItemStack[] inventory = p.getInventory().getContents();

        ItemStack itemInHand = p.getInventory().getItemInMainHand();

        BaseVape vape = null;
        BaseLiquid liquid = null;
        
        int i = -1;
        int pos = 0;

        for (ItemStack item : inventory) {
            i++;
            if (item == null) continue;
            if (item.getType() != Material.POTION) continue;

            net.minecraft.server.v1_16_R3.ItemStack nmsCopy = CraftItemStack.asNMSCopy(item);
            NBTTagCompound compound = nmsCopy.getTag();
            if (compound == null) continue;
            byte[] liquidData = compound.getByteArray("liquidData");
            if (liquidData == null) continue;

            try {
                BaseLiquid tempLiquid = (BaseLiquid) decodeObject(liquidData);

                if (Integer.parseInt(args[0]) == tempLiquid.id + 1) {
                    liquid = tempLiquid;
                    pos = i;
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        net.minecraft.server.v1_16_R3.ItemStack nmsCopy = CraftItemStack.asNMSCopy(itemInHand);
        NBTTagCompound compound = nmsCopy.getTag();
        if (compound == null) return true;
        byte[] vapeData = compound.getByteArray("vapeData");
        if (vapeData == null) return true;

        try {
            vape = (BaseVape) decodeObject(vapeData);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (vape == null || liquid == null) {
            s.sendMessage("[VapePlugin] Возьми вейп в руки и введи айди жижи, которая у тебя есть");
            return true;
        }

        if (vape.currentLiquid.currentCapacity > 0) {
            s.sendMessage("[VapePlugin] В вейпе уже есть " + vape.currentLiquid.currentCapacity + " мл жижи");
            return true;
        }

        vape.currentLiquid = liquid;

        try {
            itemInHand.setItemMeta(VapeItem.getVapeMeta(vape));

            nmsCopy = CraftItemStack.asNMSCopy(itemInHand);
            compound = (nmsCopy.hasTag()) ? nmsCopy.getTag() : new NBTTagCompound();
            compound.setByteArray("vapeData", Utils.encodeObject(vape));
            nmsCopy.setTag(compound);

            p.getInventory().setItemInMainHand(CraftItemStack.asBukkitCopy(nmsCopy));
            p.getInventory().setItem(pos, null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }
}