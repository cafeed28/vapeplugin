package com.cafeed28.vapeplugin;

import com.cafeed28.vapeplugin.types.BaseVape;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import net.minecraft.server.v1_16_R3.NBTTagCompound;
import org.bukkit.*;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static com.cafeed28.vapeplugin.Utils.*;

public class VapeItem implements Listener {
    private final VapePlugin plugin;

    private final HashMap<UUID, Long> startHoldingTimes = new HashMap<>();
    private final HashMap<UUID, BukkitRunnable> runnables = new HashMap<>();

    public VapeItem() {
        this.plugin = VapePlugin.getInstance();
    }

    public static ItemMeta getVapeMeta(BaseVape vape) {
        ItemMeta meta = new ItemStack(Material.STICK).getItemMeta();

        meta.setDisplayName(vape.name);
        meta.setLore(Arrays.asList(vape.name,
                "Айди: " + vape.id,
                "Цена: " + vape.price + " алмазов",
                "Мощность: " + vape.wattage + "W",
                "Жижа: " + vape.currentLiquid.name + ", " +
                        vape.currentLiquid.currentCapacity + "/" + vape.currentLiquid.maxCapacity + " ml",
                "Нажми ПКМ, чтобы начать затяжку", "Нажми ПКМ второй раз, чтобы закончить затяжку"));

        return meta;
    }

    public static ItemStack getVapeItem(BaseVape vape) throws IOException {
        ItemStack item = new ItemStack(Material.STICK);
        item.setItemMeta(getVapeMeta(vape));

        net.minecraft.server.v1_16_R3.ItemStack nmsCopy = CraftItemStack.asNMSCopy(item);
        NBTTagCompound compound = (nmsCopy.hasTag()) ? nmsCopy.getTag() : new NBTTagCompound();

        compound.setByteArray("vapeData", encodeObject(vape));
        nmsCopy.setTag(compound);

        item = CraftItemStack.asBukkitCopy(nmsCopy);

        return item;
    }

    private static void onHoldEnd(Player p, BaseVape vape, ItemStack item, long startHoldingTime, boolean isPerfect) throws IOException {
        int holdTime = (int) TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - startHoldingTime);

        for (int i = 0; i < vape.currentLiquid.effects.size(); i++) {
            int effectId = vape.currentLiquid.effects.get(i);
            PotionEffectType effect = PotionEffectType.getById(effectId);

            int amplifier = vape.currentLiquid.effectsAmplifier.get(i);
            int duration = vape.currentLiquid.effectsDuration.get(i) * 20;
            boolean onlyPerfect = vape.currentLiquid.effectsOnlyPerfect.get(i);

            if (!isPerfect && onlyPerfect) continue;

            p.addPotionEffect(effect.createEffect(duration, amplifier));
        }

        Location pLoc = p.getEyeLocation();
        World w = p.getWorld();

        Random rand = new Random();

        for (int i = 0; i < vape.getParticlesCount() * holdTime; i++) {
            double offset = rand.nextInt(20) / 100.0;
            w.spawnParticle(Particle.REDSTONE,
                    pLoc.getX() + offset, pLoc.getY() + offset, pLoc.getZ() + offset,
                    vape.getParticlesCount() * holdTime,
                    new Particle.DustOptions(Color.fromRGB(255, 255, 255), 1));
        }

        vape.currentLiquid.spendLiquid(holdTime, vape);
        item.setItemMeta(getVapeMeta(vape));

        net.minecraft.server.v1_16_R3.ItemStack nmsCopy = CraftItemStack.asNMSCopy(item);
        NBTTagCompound compound = (nmsCopy.hasTag()) ? nmsCopy.getTag() : new NBTTagCompound();
        compound.setByteArray("vapeData", Utils.encodeObject(vape));
        nmsCopy.setTag(compound);

        item = CraftItemStack.asBukkitCopy(nmsCopy);

        p.getInventory().setItemInMainHand(item);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) throws IOException, ClassNotFoundException {
        Player p = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_AIR) {
            ItemStack item = event.getItem();

            if (item == null) return;
            if (item.getType() != Material.STICK) return;

            net.minecraft.server.v1_16_R3.ItemStack nmsCopy = CraftItemStack.asNMSCopy(item);
            NBTTagCompound compound = nmsCopy.getTag();
            if (compound == null) return;
            byte[] vapeData = compound.getByteArray("vapeData");
            if (vapeData == null) return;

            final BaseVape vapeInfo = (BaseVape) decodeObject(vapeData);

            UUID uuid = event.getPlayer().getUniqueId();

            if (!startHoldingTimes.containsKey(uuid)) {
                if (vapeInfo.currentLiquid.currentCapacity == 0) {
                    p.spigot().sendMessage(ChatMessageType.ACTION_BAR,
                            TextComponent.fromLegacyText(ChatColor.RED + "гарик)"));

                    p.addPotionEffect(
                            PotionEffectType.WITHER.createEffect(
                                    vapeInfo.wattage * 20, 2));
                    return;
                }

                BukkitRunnable runnable = new BukkitRunnable() {
                    @Override
                    public void run() {
                        long startHoldingTime = startHoldingTimes.get(uuid);
                        int maxHoldTime = vapeInfo.getMaxHoldTime();
                        long holdTime = System.currentTimeMillis() - startHoldingTime;

                        if (holdTime < maxHoldTime) {
                            float progress = (float)holdTime / (float)maxHoldTime;
                            StringBuilder sb = new StringBuilder();
                            int length = 45;
                            for (int i = 0; i < length; i++) {
                                if (i < length * progress) {
                                    sb.append("_");
                                }
                            }

                            p.spigot().sendMessage(ChatMessageType.ACTION_BAR,
                                    TextComponent.fromLegacyText(sb.toString()));
                        } else if (holdTime >= maxHoldTime) {
                            String actionBarText = ChatColor.RED + "Слишком долго затягивался!";

                            p.spigot().sendMessage(ChatMessageType.ACTION_BAR,
                                    TextComponent.fromLegacyText(actionBarText));

                            p.addPotionEffect(
                                    PotionEffectType.CONFUSION.createEffect(
                                            vapeInfo.wattage * 20, 2));
                            p.addPotionEffect(
                                    PotionEffectType.WITHER.createEffect(
                                            vapeInfo.wattage * 20, 2));
                            p.addPotionEffect(
                                    PotionEffectType.POISON.createEffect(
                                            vapeInfo.wattage * 20, 2));

                            vapeInfo.currentLiquid.spendLiquid((int) TimeUnit.MILLISECONDS.toSeconds(holdTime), vapeInfo);

                            try {
                                onHoldEnd(p, vapeInfo, item, startHoldingTime, false);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            startHoldingTimes.remove(uuid);
                            this.cancel();
                            runnables.remove(uuid);
                        }
                    }
                };

                runnables.put(uuid, runnable);
                startHoldingTimes.put(uuid, System.currentTimeMillis());

                runnable.runTaskTimer(plugin, 0, 1);
            } else if (startHoldingTimes.containsKey(uuid)) {
                long startHoldingTime = startHoldingTimes.get(uuid);
                long holdTime = System.currentTimeMillis() - startHoldingTime;
                int maxHoldTime = vapeInfo.getMaxHoldTime();
                int perfectHoldTime = Math.round(maxHoldTime * 0.8f);

                boolean isPerfect = false;

                if (TimeUnit.MILLISECONDS.toSeconds(holdTime) == TimeUnit.MILLISECONDS.toSeconds(perfectHoldTime)) {
                    String actionBarText = String.format(
                            ChatColor.GREEN + "Идеально! "
                                    + ChatColor.GOLD + "¦"
                                    + ChatColor.WHITE + " %02d.%02d сек",
                            TimeUnit.MILLISECONDS.toSeconds(holdTime),
                            TimeUnit.MILLISECONDS.toMillis(holdTime));

                    p.spigot().sendMessage(ChatMessageType.ACTION_BAR,
                            TextComponent.fromLegacyText(actionBarText));

                    isPerfect = true;
                }

                onHoldEnd(p, vapeInfo, item, startHoldingTime, isPerfect);

                runnables.get(uuid).cancel();
                runnables.remove(uuid);
                startHoldingTimes.remove(uuid);
            }
        }
    }
}