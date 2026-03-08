// change plugin directory name, this is placeholder
package io.turbo.random.plugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Plugin extends JavaPlugin {
@Getter public Plugin instance;

 public Plugin() {
  instance = this;
 } 
  
 @Override
 public void onEnable() {
    Bukkit.getLogger().info("Enabled plugin.")    
 }
}
