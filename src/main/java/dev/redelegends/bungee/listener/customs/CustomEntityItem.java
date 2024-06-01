package dev.redelegends.bungee.listener.customs;

import dev.redelegends.libraries.holograms.api.HologramLine;
import net.minecraft.server.v1_8_R3.World;
import org.bukkit.inventory.ItemStack;

public class CustomEntityItem extends net.minecraft.server.v1_8_R3.EntityItem{
    private HologramLine hologramLine;

    public CustomEntityItem(World world) {
        super(world);
    }

    public HologramLine getHologramLine() {
        return hologramLine;
    }

    public void setHologramLine(HologramLine hologramLine) {
        this.hologramLine = hologramLine;
    }

    public void setLocation(double x, double y, double z) {
    }

    public void setItemStack(ItemStack item) {

    }
}
