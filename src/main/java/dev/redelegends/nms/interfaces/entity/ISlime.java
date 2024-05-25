package dev.redelegends.nms.interfaces.entity;

import dev.redelegends.libraries.holograms.api.HologramLine;
import dev.redelegends.libraries.holograms.api.HologramLine;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Slime;
import dev.redelegends.libraries.holograms.api.HologramLine;

public interface ISlime {
  
  void setPassengerOf(Entity entity);
  
  void setLocation(double x, double y, double z);
  
  boolean isDead();
  
  void killEntity();
  
  Slime getEntity();
  
  HologramLine getLine();
}
