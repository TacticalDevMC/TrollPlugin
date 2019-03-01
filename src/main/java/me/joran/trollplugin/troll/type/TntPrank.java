package me.joran.trollplugin.troll.type;

import me.joran.trollplugin.troll.format.PrankFormat;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;

public class TntPrank implements PrankFormat {

    @Override
    public void execute(Object[] o) {
        Player player = (Player) o[0];
        TNTPrimed tnt = player.getWorld().spawn(player.getLocation().add(0, 1, 0), TNTPrimed.class);
        tnt.setFuseTicks(80);
    }

    @Override
    public void openInventory(Player p) {

    }
}
