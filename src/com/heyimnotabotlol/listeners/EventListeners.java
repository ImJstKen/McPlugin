package com.heyimnotabotlol.listeners;

import com.heyimnotabotlol.commands.util.*;
import com.heyimnotabotlol.inventories.*;
import com.heyimnotabotlol.items.*;
import com.heyimnotabotlol.scoreboard.*;
import org.bukkit.*;
import org.bukkit.block.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.block.*;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.*;
import org.bukkit.inventory.*;

import java.util.*;

public class EventListeners implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getClickedInventory() == null) return;
        if (event.getClickedInventory().getHolder() instanceof SelectionScreen) {
            event.setCancelled(true);
            Player player = (Player) event.getWhoClicked();
            if (event.getCurrentItem() == null) return;
            if (event.getCurrentItem().getType() == Material.LIME_STAINED_GLASS_PANE) {
                player.sendMessage(ChatColor.GREEN + "Accepted!");
                player.closeInventory();
            }
            else if (event.getSlot() == 4) {
                player.sendMessage(ChatColor.AQUA + "Please make a selection!");
            }
            else if (event.getCurrentItem().getType() == Material.RED_STAINED_GLASS_PANE) {
                player.sendMessage(ChatColor.RED + "Denied!");
                player.closeInventory();
            }
        }
    }

    @EventHandler
    public void onRCGuiOpen(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK ||
                event.getAction() == Action.RIGHT_CLICK_AIR ||
                event.getAction() == Action.LEFT_CLICK_BLOCK ||
                event.getAction() == Action.LEFT_CLICK_AIR)
        {
            if (event.getItem() != null) {
                if (event.getItem().equals(ItemManager.menu)) {
                    Player player = event.getPlayer();

                    SelectionScreen gui = new SelectionScreen();
                    player.openInventory(gui.getInventory());
                }
            }
        }
    }

    @EventHandler
    public void LavariteSwordPower(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (event.getItem() != null) {
                if (Objects.equals(event.getItem().getItemMeta(), ItemManager.lavariteSword.getItemMeta())) {
                    Player player = event.getPlayer();
                    player.getWorld().createExplosion(player.getLocation(), 5.0f);
                }
            }
        }
    }

    @EventHandler
    public void onEvent() {

    }
    
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage();
        
        if (player.getDisplayName().equals("PlayerKiller211")) {
            event.setFormat(ChatColor.DARK_GRAY + "[" + ChatColor.RED + "OWNER" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_RED + "%1$s" + ": " + ChatColor.YELLOW + "%2$s");
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(ChatColor.AQUA + player.getName() + ChatColor.GREEN + " has joined the server!");

        new ScoreBoard(player);

        if (player.getInventory().contains(ItemManager.menu)) return;
        GiveItems.invAdd(player, ItemManager.menu);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
       Player player = event.getPlayer();
       event.setQuitMessage(ChatColor.AQUA + player.getName() + ChatColor.RED + " has left the server!");
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {

        if (event.getItemDrop().getName().equalsIgnoreCase(ChatColor.BOLD + ChatColor.GRAY.toString() + "§k||" + ChatColor.DARK_RED + "Menu" + ChatColor.GRAY + "§k||")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onGameModeChange(PlayerGameModeChangeEvent event) {
        Player player = event.getPlayer();
        GameMode gm = event.getNewGameMode();
        Server server = event.getPlayer().getServer();

        Bukkit.broadcastMessage(player.getName() + " changed their gamemode to " + gm.toString());
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Block block = event.getBlock();
        Player player = event.getPlayer();
        ItemStack item = new ItemStack(block.getType());

        event.setDropItems(false);
        player.getInventory().addItem(item);
    }
    
    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        Location loc = event.getRespawnLocation();
        
        Bukkit.broadcastMessage(ChatColor.AQUA + player.getName() + ChatColor.RED + " respawned at " + loc.getX() + " " + loc.getY() + " " + loc.getZ());
    }
}
