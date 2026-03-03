// change plugin directory name, this is placeholder
package io.turbo.random.plugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import lombok.Getter;
import lombok.experimental.Accessors;
import net.milkbowl.vault.economy.Economy;

public class Plugin extends JavaPlugin {
@Getter public Plugin instance;
@Getter @Accessors(fluent = true) public static Economy econ = null;
  
 @Override
 public void onEnable() {
    instance = this;
    if (!setupEconomy()) {
            getLogger().severe("Vault or an Economy provider was not found! Disabling Plugin.");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }
 }

  @Override
  public void onDisable() {
     Bukkit.getConsoleSender().sendMessage("Disabling Plugin!"); 
 } 

   private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
           Bukkit.getConsoleSender().sendMessage("Could not find vault!");             
           return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
           Bukkit.getConsoleSender().sendMessage("Could not fetch an economy provider!");
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
  }  
}
