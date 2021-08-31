package com.cafeed28.vapeplugin;

import com.cafeed28.vapeplugin.liquids.BaseLiquid;
import com.cafeed28.vapeplugin.vapes.BaseVape;
import net.minecraft.server.v1_16_R3.NBTTagCompound;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;
import java.util.ArrayList;

import static com.cafeed28.vapeplugin.Utils.decodeObject;

public class ShopManager implements Listener {
    public final ArrayList<BaseVape> vapeTypes;
    public final ArrayList<BaseLiquid> liquidTypes;

    public ShopManager() {
        vapeTypes = VapePlugin.getInstance().vapes;
        liquidTypes = VapePlugin.getInstance().liquids;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) throws IOException, ClassNotFoundException {
        if (!(e.getWhoClicked() instanceof Player)) {
            e.getWhoClicked().sendMessage("[VapePlugin] ты кто) Только игрок может использовать команду");
        }

        Player p = (Player) e.getWhoClicked();

        if (e.getClickedInventory() != null) {
            String title = e.getView().getTitle();
            ItemStack item = e.getCurrentItem();

            net.minecraft.server.v1_16_R3.ItemStack nmsCopy = CraftItemStack.asNMSCopy(item);
            NBTTagCompound compound = nmsCopy.getTag();
            if (compound == null) return;

            BaseVape vape;
            BaseLiquid liquid;
            int price = 0;

            if (title.equals("Вейп-шоп) : вейпы")) {
                byte[] vapeData = compound.getByteArray("vapeData");
                if (vapeData == null) return;

                vape = (BaseVape) decodeObject(vapeData);
                price = vape.price;
            } else if (title.equals("Вейп-шоп) : жижи")) {
                byte[] liquidData = compound.getByteArray("liquidData");
                if (liquidData == null) return;

                liquid = (BaseLiquid) decodeObject(liquidData);
                price = liquid.price;
            } else return;

            if (e.getClickedInventory().getType() == InventoryType.PLAYER) {
                e.setCancelled(true);
                return;
            }

            int diamonds = 0;
            for (ItemStack invItem : p.getInventory().getContents()) {
                if (invItem == null) continue;
                if (invItem.getType() != Material.DIAMOND) continue;
                diamonds += invItem.getAmount();
                break;
            }

            if (diamonds < price) {
                p.sendMessage("[VapePlugin] У тебя недостаточно алмазов!");
                e.setCancelled(true);
                return;
            }

            diamonds -= price;

            for (ItemStack invItem : p.getInventory().getContents()) {
                if (invItem == null) continue;
                if (invItem.getType() != Material.DIAMOND) continue;
                invItem.setAmount(diamonds);
                break;
            }

            p.getInventory().addItem(item);
            e.setCancelled(true);
        }
    }
}