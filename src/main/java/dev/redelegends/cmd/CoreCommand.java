package dev.redelegends.cmd;

import dev.redelegends.database.Database;
import dev.redelegends.Core;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CoreCommand extends Commands {
  
  public CoreCommand() {
    super("legendscore", "lc");
  }
  
  @Override
  public void perform(CommandSender sender, String label, String[] args) {
    if (sender instanceof Player) {
      Player player = (Player) sender;
      if (!player.hasPermission("legendscore.admin")) {
        player.sendMessage("§6LegendsCore §bv" + Core.getInstance().getDescription().getVersion() + " §7Criado por §6nevesbr6§7 e §6shauuu_§7.");
        return;
      }

      if (args.length == 0) {
        player.sendMessage(" \n§6/lc converter §f- §7Converter seu Banco de Dados.\n ");
        return;
      }
      
      String action = args[0];
    } else {
      sender.sendMessage("§cApenas jogadores podem utilizar este comando.");
    }
  }
}
