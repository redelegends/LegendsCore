package dev.redelegends.nms.v1_8_R3.utils;

import dev.redelegends.libraries.npclib.api.npc.NPC;
import dev.redelegends.libraries.npclib.npc.skin.SkinnableEntity;
import dev.redelegends.nms.v1_8_R3.entity.EntityNPCPlayer;
import dev.redelegends.libraries.npclib.api.npc.NPC;
import dev.redelegends.libraries.npclib.npc.skin.SkinnableEntity;
import dev.redelegends.nms.v1_8_R3.entity.EntityNPCPlayer;
import net.minecraft.server.v1_8_R3.*;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import dev.redelegends.libraries.npclib.api.npc.NPC;
import dev.redelegends.libraries.npclib.npc.skin.SkinnableEntity;
import dev.redelegends.nms.v1_8_R3.entity.EntityNPCPlayer;

import java.lang.reflect.Field;

public class PlayerlistTrackerEntry extends EntityTrackerEntry {
  
  private static Field U;
  
  static {
    try {
      U = EntityTrackerEntry.class.getDeclaredField("u");
      U.setAccessible(true);
    } catch (ReflectiveOperationException e) {
      e.printStackTrace();
    }
  }
  
  public PlayerlistTrackerEntry(Entity entity, int i, int j, boolean flag) {
    super(entity, i, j, flag);
  }
  
  public PlayerlistTrackerEntry(EntityTrackerEntry entry) {
    this(entry.tracker, entry.b, entry.c, getU(entry));
  }
  
  static boolean getU(EntityTrackerEntry entry) {
    try {
      return (boolean) U.get(entry);
    } catch (ReflectiveOperationException e) {
      e.printStackTrace();
    }
    
    return false;
  }
  
  @Override
  public void updatePlayer(EntityPlayer entityplayer) {
    if (entityplayer instanceof EntityNPCPlayer) {
      return;
    }
    
    
    boolean layingSend = false;
    if (entityplayer != tracker && c(entityplayer)) {
      if (!trackedPlayers.contains(entityplayer) && (entityplayer.u().getPlayerChunkMap().a(entityplayer, tracker.ae, tracker.ag) || tracker.attachedToPlayer)) {
        if (tracker instanceof SkinnableEntity) {
          SkinnableEntity entity = (SkinnableEntity) tracker;
          dev.redelegends.libraries.npclib.api.npc.NPC npc = entity.getNPC();
          if (npc.data().has(NPC.ATTACHED_PLAYER) && !npc.data().get(NPC.ATTACHED_PLAYER).equals(entityplayer.getName())) {
            entityplayer.getBukkitEntity().hidePlayer(entity.getEntity());
            return;
          }
          
          Player player = entity.getEntity();
          if (entityplayer.getBukkitEntity().canSee(player)) {
            entity.getSkinTracker().updateViewer(entityplayer.getBukkitEntity());
            layingSend = true;
          }
        }
      }
    }
    
    super.updatePlayer(entityplayer);
    if (layingSend) {
      Player player = entityplayer.getBukkitEntity();
      NPC npc = ((SkinnableEntity) tracker).getNPC();
      if (entityplayer.getBukkitEntity().canSee(player) && npc.isLaying()) {
        Location bedLocation = tracker.getBukkitEntity().getLocation();
        bedLocation.setY(0);
        player.sendBlockChange(bedLocation, Material.BED_BLOCK, (byte) 0);
        entityplayer.playerConnection
            .sendPacket(new PacketPlayOutBed((EntityHuman) tracker, new BlockPosition(bedLocation.getBlockX(), bedLocation.getBlockY(), bedLocation.getBlockZ())));
      }
    }
  }
}
