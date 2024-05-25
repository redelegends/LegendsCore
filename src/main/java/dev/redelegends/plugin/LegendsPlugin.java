package dev.redelegends.plugin;

import dev.redelegends.reflection.Accessors;
import dev.redelegends.plugin.config.FileUtils;
import dev.redelegends.plugin.config.LegendsConfig;
import dev.redelegends.plugin.config.LegendsWriter;
import dev.redelegends.plugin.logger.LegendsLogger;
import dev.redelegends.reflection.acessors.FieldAccessor;
import org.bukkit.plugin.PluginLogger;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.sql.SQLException;

public abstract class LegendsPlugin extends JavaPlugin {
  
  private static final FieldAccessor<PluginLogger> LOGGER_ACCESSOR = Accessors.getField(JavaPlugin.class, "logger", PluginLogger.class);
  private final FileUtils fileUtils;
  
  public LegendsPlugin() {
    this.fileUtils = new FileUtils(this);
    LOGGER_ACCESSOR.set(this, new LegendsLogger(this));
    
    this.start();
  }
  
  public abstract void start();
  
  public abstract void load();
  
  public abstract void enable();
  
  public abstract void disable() throws SQLException;
  
  @Override
  public void onLoad() {
    this.load();
  }
  
  @Override
  public void onEnable() {
    this.enable();
  }
  
  @Override
  public void onDisable() {
  }
  
  public LegendsConfig getConfig(String name) {
    return this.getConfig("", name);
  }
  
  public LegendsConfig getConfig(String path, String name) {
    return LegendsConfig.getConfig(this, "plugins/" + this.getName() + "/" + path, name);
  }
  
  public LegendsWriter getWriter(File file) {
    return this.getWriter(file, "");
  }
  
  public LegendsWriter getWriter(File file, String header) {
    return new LegendsWriter((LegendsLogger) this.getLogger(), file, header);
  }
  
  public FileUtils getFileUtils() {
    return this.fileUtils;
  }
}
