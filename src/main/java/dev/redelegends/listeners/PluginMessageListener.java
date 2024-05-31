package dev.redelegends.listeners;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import dev.redelegends.player.fake.FakeManager;
import dev.redelegends.utils.enums.EnumSound;
import dev.redelegends.bukkit.BukkitParty;
import dev.redelegends.bukkit.BukkitPartyManager;
import dev.redelegends.nms.NMS;
import dev.redelegends.party.PartyPlayer;
import dev.redelegends.player.Profile;
import dev.redelegends.player.fake.FakeManager;
import dev.redelegends.utils.enums.EnumSound;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import dev.redelegends.player.fake.FakeManager;
import dev.redelegends.utils.enums.EnumSound;

import static dev.redelegends.party.PartyRole.MEMBER;

public class PluginMessageListener implements org.bukkit.plugin.messaging.PluginMessageListener {
  
  @Override
  public void onPluginMessageReceived(String channel, Player receiver, byte[] data) {
    if (channel.equals("LegendsCore")) {
      ByteArrayDataInput in = ByteStreams.newDataInput(data);
      
      String subChannel = in.readUTF();
      switch (subChannel) {
        case "FAKE": {
          Player player = Bukkit.getPlayerExact(in.readUTF());
          if (player != null) {
            String fakeName = in.readUTF();
            String roleName = in.readUTF();
            String skin = in.readUTF();
            FakeManager.applyFake(player, fakeName, roleName, skin);
            NMS.refreshPlayer(player);
          }
          break;
        }
        case "FAKE_BOOK": {
          Player player = Bukkit.getPlayerExact(in.readUTF());
          if (player != null) {
            try {
              String sound = in.readUTF();
              EnumSound.valueOf(sound).play(player, 1.0F, sound.contains("VILL") ? 1.0F : 2.0F);
            } catch (Exception ignore) {
            }
            FakeManager.sendRole(player);
          }
          break;
        }
        case "SEND_PARTY": {
          Player player = Bukkit.getPlayerExact(in.readUTF());
          Player leader = Bukkit.getPlayerExact(in.readUTF());
          if (player != null && leader != null) {
            Profile profile = Profile.getProfile(player.getName());
            Profile pLeader = Profile.getProfile(leader.getName());
            if (pLeader.getGame() == null) {
              return;
            }
            if (profile.getGame() != null) {
              profile.getGame().leave(profile, null);
            }
            pLeader.getGame().join(profile);
          }
        }
        case "FAKE_BOOK2": {
          Player player = Bukkit.getPlayerExact(in.readUTF());
          if (player != null) {
            String roleName = in.readUTF();
            String sound = in.readUTF();
            EnumSound.valueOf(sound).play(player, 1.0F, sound.contains("VILL") ? 1.0F : 2.0F);
            FakeManager.sendSkin(player, roleName);
          }
          break;
        }
        case "PARTY":
          try {
            JSONObject changes = (JSONObject) new JSONParser().parse(in.readUTF());
            String leader = changes.get("leader").toString();
            boolean delete = changes.containsKey("delete");
            BukkitParty party = BukkitPartyManager.getLeaderParty(leader);
            if (party == null) {
              if (delete) {
                return;
              }
              party = BukkitPartyManager.createParty(leader, 0);
            }
            
            if (delete) {
              party.delete();
              return;
            }
            
            if (changes.containsKey("newLeader")) {
              party.transfer(changes.get("newLeader").toString());
            }
            
            if (changes.containsKey("remove")) {
              party.listMembers().removeIf(pp -> pp.getName().equalsIgnoreCase(changes.get("remove").toString()));
            }
            
            for (Object object : (JSONArray) changes.get("members")) {
              if (!party.isMember(object.toString())) {
                party.listMembers().add(new PartyPlayer(object.toString(), MEMBER));
              }
            }
          } catch (ParseException ignore) {
          }
          break;
      }
    }
  }
}
