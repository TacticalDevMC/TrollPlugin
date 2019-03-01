package me.joran.trollplugin;

import me.joran.trollplugin.handlers.StartUpHandlers;
import me.joran.trollplugin.troll.inventory.manager.PrankManager;
import me.joran.trollplugin.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main instance;
    private PrankManager prankManager;

    public PrankManager getPrankManager() {
        return prankManager;
    }

    @Override
    public void onEnable() {
        instance = this;

        StartUpHandlers.registerFiles();
        StartUpHandlers.registerCommands();
        StartUpHandlers.registerListeners(getServer().getPluginManager());
        ConsoleCommandSender console = Bukkit.getConsoleSender();
        console.sendMessage(ChatUtils.getPrefix() + ChatUtils.color("&aDe plugin staat aan. Author:" + getDescription().getAuthors() + " V" + getDescription().getVersion()));

    }

    @Override
    public void onDisable() {
        ConsoleCommandSender console = Bukkit.getConsoleSender();
        console.sendMessage(ChatUtils.getPrefix() + ChatUtils.color("&aDe plugin staat uit. Author:" + getDescription().getAuthors() + " V" + getDescription().getVersion()));
    }

    public static Main getInstance() {
        return instance;
    }
}
