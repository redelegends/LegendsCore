package dev.redelegends.bungee.listener;

import dev.redelegends.libraries.holograms.api.HologramLine;
import dev.redelegends.nms.interfaces.entity.ISlime;
import net.minecraft.server.v1_8_R3.EntitySlime;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Slime;

public class SlimeAdapter implements ISlime {

    private final EntitySlime entitySlime;

    public SlimeAdapter(EntitySlime entitySlime) {
        this.entitySlime = entitySlime;
    }

    @Override
    public void setPassengerOf(Entity entity) {

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
    public Slime getEntity() {
        return null;
    }

    @Override
    public HologramLine getLine() {
        return null;
    }
}
