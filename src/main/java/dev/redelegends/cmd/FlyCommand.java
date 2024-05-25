package dev.redelegends.cmd;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand extends Commands{

    public FlyCommand() {
        super("fly");
    }

    @Override
    public void perform(CommandSender sender, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cApenas jogadores podem usar este comando.");
            return;
        }

        Player player = (Player) sender;

        if (!sender.hasPermission("legendscore.command.fly")) {
            sender.sendMessage("§cVocê não tem permissão para usar este comando.");
            return;
        }

        boolean isFlying = player.getAllowFlight();
        player.setAllowFlight(!isFlying);
        player.setFlying(!isFlying);

        if (isFlying) {
            sender.sendMessage("§aModo de voo desativado.");
        } else {
            sender.sendMessage("§aModo de voo ativado.");
        }
    }

}
