package me.joran.trollplugin.players.commands;

import me.joran.trollplugin.Main;
import me.joran.trollplugin.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PrankCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Utils.color("&c&lOnly players can do this!"));
            return true;
        }

        Player player = (Player) sender;
        player.openInventory(Main.getInstance().getPrankManager().getPlayerList(player));
        return false;
    }
}
