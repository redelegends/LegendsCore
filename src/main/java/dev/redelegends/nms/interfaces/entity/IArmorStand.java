package dev.redelegends.nms.interfaces.entity;

import dev.redelegends.libraries.holograms.api.HologramLine;
import dev.redelegends.libraries.holograms.api.HologramLine;
import org.bukkit.entity.ArmorStand;
import dev.redelegends.libraries.holograms.api.HologramLine;

public interface IArmorStand {
  
  int getId();
  
  void setName(String name);
  
  void setLocation(double x, double y, double z);
  
  boolean isDead();
  
  void killEntity();
  
  ArmorStand getEntity();
  
  HologramLine getLine();
}
