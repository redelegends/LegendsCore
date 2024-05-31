package dev.redelegends.game;

import dev.redelegends.player.Profile;
import dev.redelegends.player.Profile;
import org.bukkit.entity.Player;
import dev.redelegends.player.Profile;

import java.util.List;

public interface Game<T extends GameTeam> {
  
  void broadcastMessage(String message);
  
  void broadcastMessage(String message, boolean spectators);
  
  void join(Profile profile);
  
  void leave(Profile profile, Game<?> game);
  
  void kill(Profile profile, Profile killer);
  
  void killLeave(Profile profile, Profile killer);
  
  void start();
  
  void stop(T winners);
  
  void reset();
  
  String getGameName();
  
  GameState getState();
  
  boolean isSpectator(Player player);
  
  int getOnline();
  
  int getMaxPlayers();
  
  T getTeam(Player player);
  
  List<T> listTeams();
  
  List<Player> listPlayers();
  
  List<Player> listPlayers(boolean spectators);
}
