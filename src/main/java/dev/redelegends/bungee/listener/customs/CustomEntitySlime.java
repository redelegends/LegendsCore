package dev.redelegends.bungee.listener.customs;

import dev.redelegends.libraries.holograms.api.HologramLine;
import net.minecraft.server.v1_8_R3.World;

public class CustomEntitySlime extends net.minecraft.server.v1_8_R3.EntitySlime{
    private HologramLine hologramLine;

    public CustomEntitySlime(World world) {
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
}
