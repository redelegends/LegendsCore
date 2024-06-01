package dev.redelegends.bungee.listener.customs;

import dev.redelegends.libraries.holograms.api.HologramLine;
import net.minecraft.server.v1_8_R3.World;

public class CustomEntityArmorStand extends net.minecraft.server.v1_8_R3.EntityArmorStand{

    private HologramLine hologramLine;

    public CustomEntityArmorStand(World world) {
        super(world);
    }

    public HologramLine getHologramLine() {
        return hologramLine;
    }

    public void setHologramLine(HologramLine hologramLine) {
        this.hologramLine = hologramLine;
    }


}
