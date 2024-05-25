package dev.redelegends.libraries.npclib.api;

import dev.redelegends.libraries.npclib.api.npc.NPC;
import dev.redelegends.libraries.npclib.api.npc.NPC;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import dev.redelegends.libraries.npclib.api.npc.NPC;

public interface EntityController {
  
  void spawn(Location location, NPC npc);
  
  void remove();
  
  Entity getBukkitEntity();
}
