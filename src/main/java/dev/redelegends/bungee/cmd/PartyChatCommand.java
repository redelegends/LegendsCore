package dev.redelegends.bungee.cmd;

import dev.redelegends.bungee.party.BungeeParty;
import dev.redelegends.bungee.party.BungeePartyManager;
import dev.redelegends.bungee.party.BungeeParty;
import dev.redelegends.bungee.party.BungeePartyManager;
import dev.redelegends.player.role.Role;
import dev.redelegends.utils.StringUtils;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import dev.redelegends.bungee.party.BungeeParty;
import dev.redelegends.bungee.party.BungeePartyManager;

public class PartyChatCommand extends Commands {
  
  public PartyChatCommand() {
    super("p");
  }
  
  @Override
  public void perform(CommandSender sender, String[] args) {
    if (!(sender instanceof ProxiedPlayer)) {
      sender.sendMessage(TextComponent.fromLegacyText("§cApenas jogadores podem utilizar este comando."));
      return;
    }
    
    ProxiedPlayer player = (ProxiedPlayer) sender;
    if (args.length == 0) {
      player.sendMessage(TextComponent.fromLegacyText("§cUtilize /p [mensagem] para conversar com a sua Party."));
      return;
    }
    
    BungeeParty party = BungeePartyManager.getMemberParty(player.getName());
    if (party == null) {
      player.sendMessage(TextComponent.fromLegacyText("§cVocê não pertence a uma Party."));
      return;
    }
    
    party.broadcast("§d[Party] " + Role.getPrefixed(player.getName()) + "§f: " + StringUtils.join(args, " "));
  }
}
