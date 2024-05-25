package dev.redelegends.cmd;

import dev.redelegends.player.Profile;
import dev.redelegends.utils.StringUtils;
import dev.redelegends.player.Profile;
import dev.redelegends.utils.StringUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import dev.redelegends.player.Profile;
import dev.redelegends.utils.StringUtils;

public class CoinsCommand extends Commands {
  
  public CoinsCommand() {
    super("coins");
  }

  @Override
  public void perform(CommandSender sender, String label, String[] args) {
    if (sender instanceof Player) {
      Player player = (Player) sender;
      Profile profile = Profile.getProfile(player.getName());
      if (profile == null) {
        player.sendMessage("§cPerfil não encontrado.");
        return;
      }
      player.sendMessage("\n§eSeus coins:");

      for (String name : new String[]{"Bed Wars", "Murder", "The Bridge", "Sky Wars"}) {
        try {
          double coins = profile.getCoins("LegendsCore" + name.replace(" ", ""));
          player.sendMessage(" §8▪ §f" + name + " §7" + StringUtils.formatNumber(coins));
        } catch (IllegalStateException e) {
          player.sendMessage(" §8▪ §f" + name + " §7" + "0");
        }
      }

      player.sendMessage("\n");
    } else {
      sender.sendMessage("§cApenas jogadores podem utilizar este comando.");
    }
  }
}