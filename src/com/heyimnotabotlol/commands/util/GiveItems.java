package com.heyimnotabotlol.commands.util;

import com.heyimnotabotlol.items.*;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;

public class GiveItems implements CommandExecutor {

    public static void invAdd(Player player, ItemStack item) {
        player.getInventory().addItem(item);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return true;

        Player player = (Player) sender;
        if (!player.isOp()) return true;

        switch (args[0].toLowerCase()) {
            case "lavarite_sword": {
                invAdd(player, ItemManager.lavariteSword);
                break;
            }
            case "wand": {
                invAdd(player, ItemManager.wand);
                break;
            }
            case "menu": {
                invAdd(player, ItemManager.menu);
                break;
            }
            default: {
                sender.sendMessage(ChatColor.RED + "Invalid syntax! Use " + ChatColor.YELLOW + "\"/giveitem [ item ]\".");
            }
        }

        return false;
    }
}
