package dev.redelegends.bungee.listener;

import dev.redelegends.libraries.holograms.api.HologramLine;
import dev.redelegends.nms.interfaces.entity.IItem;
import net.minecraft.server.v1_8_R3.EntityItem;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;

public class ItemAdapter implements IItem {

    private final EntityItem entityItem;

    public ItemAdapter(EntityItem entityItem) {
        this.entityItem = entityItem;
    }

    @Override
    public void setPassengerOf(Entity entity) {

    }

    @Override
    public void setItemStack(ItemStack item) {

    }

    @Override
    public void setLocation(double x, double y, double z) {

    }

    @Override
    public boolean isDead() {
        return false;
    }

    @Override
    public void killEntity() {

    }

    @Override
    public Item getEntity() {
        return null;
    }

    @Override
    public HologramLine getLine() {
        return null;
    }
}
