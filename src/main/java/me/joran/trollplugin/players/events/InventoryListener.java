package me.joran.trollplugin.players.events;

import me.joran.trollplugin.Main;
import me.joran.trollplugin.troll.enums.Prank;
import me.joran.trollplugin.troll.inventory.PrankInventory;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;


import java.util.HashMap;
import java.util.regex.Pattern;

public class InventoryListener implements Listener {

    private HashMap<String, Player> playerMap = new HashMap<>();

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player p = (Player) event.getWhoClicked();
        if (event.getInventory().equals(Main.getInstance().getPrankManager().getPlayerInventory())) {
            event.setCancelled(true);
            if (event.getCurrentItem().getType().equals(Material.SKULL_ITEM)) {
                SkullMeta meta = (SkullMeta) event.getCurrentItem().getItemMeta();
                String s = ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', event.getCurrentItem().getItemMeta().getDisplayName()));
                Player target = Bukkit.getPlayer(stripColor(s));
                p.closeInventory();
                Main.getInstance().getPrankManager().openMenu(p, target);
                return;
            }
        }

        ItemStack itemStack = event.getCurrentItem();
        if (Main.getInstance().getPrankManager().getPlayerPrankInventory().containsKey(p)) {
            PrankInventory prankInventory = Main.getInstance().getPrankManager().getPlayerPrankInventory().get(p);
            for (Prank prank : Prank.values()) {
                if (prank.getItemStack().equals(itemStack)) {
                    event.setCancelled(true);
                    if (prank.getPrankFormat().equals(Prank.TNT_PRANK.getPrankFormat())) {
                        Prank.TNT_PRANK.getPrankFormat().execute(new Object[]{prankInventory.getTarget()});
                        p.closeInventory();
                    }
                }
            }
        }
    }

    private Pattern STRIP_COLOR_PATTERN = Pattern.compile("(?i)" + String.valueOf('&') + "[0-9A-FK-OR]");

    public String stripColor(String input) {
        return input == null ? null : STRIP_COLOR_PATTERN.matcher(input).replaceAll("");
    }
}
