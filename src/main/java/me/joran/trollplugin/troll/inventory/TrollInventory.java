package me.joran.trollplugin.troll.inventory;

import org.bukkit.entity.Player;

public class TrollInventory {

    private Player sender;
    private Player target;

    public TrollInventory(Player sender, Player target) {
        this.sender = sender;
        this.target = target;
    }
}
