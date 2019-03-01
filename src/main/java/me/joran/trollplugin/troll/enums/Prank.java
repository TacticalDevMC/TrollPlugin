package me.joran.trollplugin.troll.enums;

import me.joran.trollplugin.troll.format.PrankFormat;
import me.joran.trollplugin.troll.type.TntPrank;
import me.joran.trollplugin.utils.ItemBuilder;
import me.joran.trollplugin.utils.Utils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum Prank {

    TNT_PRANK(new ItemBuilder(Material.TNT).setDisplayName(Utils.color("&c&lTNT Prank")).addLore(Utils.color("&7Press this item to summon TNT")).addLore(Utils.color("&7to the players location.")).build(), new TntPrank());

    private final ItemStack itemStack;
    private final PrankFormat prankFormat;

    public ItemStack getItemStack() {
        return this.itemStack;
    }

    public PrankFormat getPrankFormat() {
        return this.prankFormat;
    }

    Prank(ItemStack itemStack, PrankFormat format) {
        this.itemStack = itemStack;
        this.prankFormat = format;
    }
}
