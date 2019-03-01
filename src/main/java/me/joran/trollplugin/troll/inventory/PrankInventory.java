package me.joran.trollplugin.troll.inventory;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class PrankInventory {

    private Inventory inventory;
    private Player target;
    private Player player;

    public Player getTarget() {
        return this.target;
    }

    public Player getPlayer() {
        return player;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public PrankInventory(Player target, Player player, Inventory inventory) {
        this.inventory = inventory;
        this.target = target;
        this.player = player;
    }
}
