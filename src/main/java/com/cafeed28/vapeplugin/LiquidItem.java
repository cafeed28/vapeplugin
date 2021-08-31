package com.cafeed28.vapeplugin;

import com.cafeed28.vapeplugin.liquids.BaseLiquid;
import net.minecraft.server.v1_16_R3.NBTTagCompound;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffectType;

import java.io.IOException;
import java.util.Arrays;

public class LiquidItem {
    public static ItemStack getLiquidItem(BaseLiquid liquid) throws IOException {
        ItemStack item = new ItemStack(Material.POTION);
        PotionMeta meta = (PotionMeta) item.getItemMeta();

        meta.addCustomEffect(PotionEffectType.HARM.createEffect(20*60*10, 10), false);

        meta.setDisplayName(liquid.name);
        meta.setLore(Arrays.asList(liquid.name,
                "Айди: " + liquid.id,
                "Цена: " + liquid.price + " алмазов",
                liquid.currentCapacity + "/" + liquid.maxCapacity + " ml",
                "Возьми в руки вейп и используй /fill, чтобы заправить"));
        meta.setColor(Color.fromRGB(liquid.colorR, liquid.colorG, liquid.colorB));

        item.setItemMeta(meta);

        net.minecraft.server.v1_16_R3.ItemStack nmsCopy = CraftItemStack.asNMSCopy(item);
        NBTTagCompound compound = (nmsCopy.hasTag()) ? nmsCopy.getTag() : new NBTTagCompound();

        compound.setByteArray("liquidData", Utils.encodeObject(liquid));
        nmsCopy.setTag(compound);

        item = CraftItemStack.asBukkitCopy(nmsCopy);

        return item;
    }
}