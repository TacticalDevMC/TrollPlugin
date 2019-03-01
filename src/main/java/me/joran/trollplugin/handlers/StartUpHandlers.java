package me.joran.trollplugin.handlers;

import me.joran.trollplugin.Main;
import me.joran.trollplugin.players.commands.PrankCommand;
import me.joran.trollplugin.players.events.InventoryListener;
import org.bukkit.plugin.PluginManager;
import me.joran.trollplugin.utils.FileManager;

public class StartUpHandlers {

    public static void registerFiles() {
        FileManager.load(Main.getInstance(), "config.yml");
    }

    public static void registerCommands() {
        Main.getInstance().getCommand("prank").setExecutor(new PrankCommand());
    }

    public static void registerListeners(PluginManager pm) {
        pm.registerEvents(new InventoryListener(), Main.getInstance());
    }
}
