package me.joran.trollplugin.utils;

import org.bukkit.ChatColor;

public class ChatUtils {

    private static String prefix = (String) FileManager.get("config.yml").get("prefix").toString().replace('&', '§');

    public static String color(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static String getPrefix() {
        return prefix = prefix;
    }
}
