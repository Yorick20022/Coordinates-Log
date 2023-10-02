package CoordsLog.CoordsLog;

import org.bukkit.plugin.java.JavaPlugin;


public final class CoordsLog extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new LocationListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}