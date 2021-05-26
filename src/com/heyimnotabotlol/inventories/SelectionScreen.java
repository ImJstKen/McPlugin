package com.heyimnotabotlol.inventories;

import org.bukkit.*;
import org.bukkit.event.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

import java.util.*;

public class SelectionScreen implements InventoryHolder {

    private Inventory inv;

    public SelectionScreen() {
        inv = Bukkit.createInventory(this, 9, "Selection Screen");
        init();
    }

    private void init() {
        ItemStack accept;
        for (int i = 0; i < 4; i++) {
            accept = createItem(ChatColor.GREEN + "Accept", Material.LIME_STAINED_GLASS_PANE, Collections.singletonList(ChatColor.GREEN + "Accept"));
            inv.setItem(i, accept);
        }

        ItemStack select;
        select = createItem("Select", Material.BOOK, Collections.singletonList("Please make a decision!"));
        inv.setItem(4, select);

        ItemStack deny;
        for (int i = 5; i < 9; i++) {
            deny = createItem(ChatColor.RED + "Deny", Material.RED_STAINED_GLASS_PANE, Collections.singletonList(ChatColor.RED + "Deny"));
            inv.setItem(i, deny);
        }
    }

    private ItemStack createItem(String name, Material mat, List<String> lore) {
        ItemStack item = new ItemStack(mat, 1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName(name);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    @Override
    public Inventory getInventory() {
        return inv;
    }
}
