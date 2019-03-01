package me.joran.trollplugin.troll.inventory.manager;

import me.joran.trollplugin.troll.enums.Prank;
import me.joran.trollplugin.troll.inventory.PrankInventory;
import me.joran.trollplugin.utils.ItemBuilder;
import me.joran.trollplugin.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class PrankManager {

    private Inventory playerInventory;

    public Inventory getPlayerInventory() {
        return this.playerInventory;
    }

    private HashMap<Player, PrankInventory> playerPrankInventory = new HashMap<>();

    public HashMap<Player, PrankInventory> getPlayerPrankInventory() {
        return playerPrankInventory;
    }

    public Inventory getPlayerList(Player playerSender) {
        int count = Bukkit.getOnlinePlayers().size() - 1;
        Inventory inventory = Bukkit.createInventory(null, fit(count), "Players");
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (!player.getName().equalsIgnoreCase(playerSender.getName())) {
                ItemStack head = new ItemBuilder(Material.SKULL_ITEM, (short) 3).setAmount(1).setDisplayName(Utils.color("&6&l" + player.getName())).setHead(player.getName()).build();
                inventory.addItem(head);
            }
        }
        this.playerInventory = inventory;
        return inventory;
    }

    public void openMenu(Player player, Player target) {
        Inventory inv = Bukkit.createInventory(null, fit(Prank.values().length), "Prank " + target.getName());
        for (Prank prank : Prank.values()) {
            inv.addItem(prank.getItemStack());
        }
        this.playerPrankInventory.put(player, new PrankInventory(target, player, inv));
        player.openInventory(inv);
    }

    public static int fit(int size) {
        if (size < 10 && size >= 1) {
            return 9;
        } else if (size < 19 && size > 9) {
            return 18;
        } else if (size < 28 && size > 18) {
            return 27;
        } else if (size < 37 && size > 27) {
            return 36;
        } else if (size < 46 && size > 36) {
            return 45;
        } else {
            return 54;
        }
    }
}
