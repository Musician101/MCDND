package io.musician101.mcdnd.spigot;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class McdndSpigot extends JavaPlugin implements Listener {

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getServer().getPluginManager().registerEvents(this, this);
    }
}
