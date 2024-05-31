package dev.redelegends.libraries.menu;

import dev.redelegends.plugin.LegendsPlugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class PlayerMenu extends Menu implements Listener {
  
  protected Player player;
  
  public PlayerMenu(Player player, String title) {
    this(player, title, 3);
  }
  
  public PlayerMenu(Player player, String title, int rows) {
    super(title, rows);
    this.player = player;
  }
  
  public void register(LegendsPlugin plugin) {
    Bukkit.getPluginManager().registerEvents(this, plugin);
  }
  
  public void open() {
    this.player.openInventory(getInventory());
  }
  
  public Player getPlayer() {
    return player;
  }
}
