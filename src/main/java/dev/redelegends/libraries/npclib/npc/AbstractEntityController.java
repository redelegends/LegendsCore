package dev.redelegends.libraries.npclib.npc;

import dev.redelegends.libraries.npclib.api.npc.NPC;
import dev.redelegends.libraries.npclib.api.EntityController;
import dev.redelegends.libraries.npclib.api.npc.NPC;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import dev.redelegends.libraries.npclib.api.npc.NPC;

public abstract class AbstractEntityController implements EntityController {
  
  private Entity bukkitEntity;
  
  protected abstract Entity createEntity(Location location, NPC npc);
  
  @Override
  public void spawn(Location location, NPC npc) {
    this.bukkitEntity = createEntity(location, npc);
  }
  
  @Override
  public void remove() {
    if (this.bukkitEntity != null) {
      this.bukkitEntity.remove();
      this.bukkitEntity = null;
    }
  }
  
  @Override
  public Entity getBukkitEntity() {
    return this.bukkitEntity;
  }
}
