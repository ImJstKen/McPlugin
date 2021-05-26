package com.heyimnotabotlol.items;

import org.bukkit.*;
import org.bukkit.enchantments.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

import java.util.*;

public class ItemManager {

    public static ItemStack lavariteSword;
    public static ItemStack wand;
    public static ItemStack menu;

    public static void init() {
        createLavariteSword();
        createWand();
        createMenuItem();
    }

    private static void createLavariteSword() {
        ItemStack item = new ItemStack(Material.NETHERITE_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName(ChatColor.RED + "Lavarite Sword");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "The best sword in the game!");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 100, true);
        meta.addEnchant(Enchantment.FIRE_ASPECT, 10, true);
        meta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 10, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        lavariteSword = item;

        // Furnace recipe
        FurnaceRecipe fr = new FurnaceRecipe(NamespacedKey.minecraft("lavarite_sword"), item, Material.NETHERITE_SWORD, 1000.0f, 200);
        Bukkit.getServer().addRecipe(fr);
    }

    private static void createWand() {
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName(ChatColor.GOLD + "Wand");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "Magic wand");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        wand = item;

        // Shaped recipe
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("wand"), item);
        sr.shape(
                "B  ",
                " S ",
                "  S"
        );
        sr.setIngredient('B', Material.BLAZE_POWDER);
        sr.setIngredient('S', Material.STICK);
        Bukkit.getServer().addRecipe(sr);

        // Shapeless recipe
        ShapelessRecipe slr = new ShapelessRecipe(NamespacedKey.minecraft("shapeless_wand"), item);
        slr.addIngredient(2, Material.BLAZE_POWDER);
        slr.addIngredient(1, Material.DIAMOND);
        Bukkit.getServer().addRecipe(slr);
    }

    private static void createMenuItem() {
        ItemStack item = new ItemStack(Material.CLOCK, 1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName(ChatColor.BOLD + ChatColor.GRAY.toString() + "§k||" + ChatColor.DARK_RED + "Menu" + ChatColor.GRAY + "§k||");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "Menu");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        menu = item;
    }
}
