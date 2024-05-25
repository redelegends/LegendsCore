package dev.redelegends.cmd;

import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameModeCommand extends Commands{

    public GameModeCommand() {
        super("gm");
    }

    @Override
    public void perform(CommandSender sender, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cApenas jogadores podem usar este comando.");
            return;
        }

        Player player = (Player) sender;

        if (!sender.hasPermission("legendscore.command.gm")) {
            sender.sendMessage("§cVocê não tem permissão para usar este comando.");
            return;
        }

        if (args.length == 0) {
            sender.sendMessage("§cUtilize /gm [0|1|2|3]");
            return;
        }

        String mode = args[0];

        switch (mode) {
            case "0":
                player.setGameMode(GameMode.SURVIVAL);
                sender.sendMessage("§aSeu modo de jogo foi alterado para §bSobrevivência§a.");
                break;
            case "1":
                player.setGameMode(GameMode.CREATIVE);
                sender.sendMessage("§aSeu modo de jogo foi alterado para §bCriativo§a.");
                break;
            case "2":
                player.setGameMode(GameMode.ADVENTURE);
                sender.sendMessage("§aSeu modo de jogo foi alterado para §bAventura§a.");
                break;
            case "3":
                player.setGameMode(GameMode.SPECTATOR);
                sender.sendMessage("§aSeu modo de jogo foi alterado para §bEspectador§a.");
                break;
            default:
                sender.sendMessage("§cUtilize /gm [0|1|2|3]");
                break;
        }
    }

}
