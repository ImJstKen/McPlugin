package com.heyimnotabotlol.commands.util;

import com.heyimnotabotlol.utils.*;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;

import java.io.IOException;

public class BackPackCommand implements CommandExecutor {

    private Inventory inventory;

    public BackPackCommand() {

        int slots = 27;

        if (Config.contains("command.backpack.slots")) {
            slots = (int) Config.get("command.backpack.slots");
        } else {
            try {
                Config.set("command.backpack.slots", 27);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        this.inventory = Bukkit.createInventory(null, slots, ChatColor.AQUA + "Backpack");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
          Player player = (Player) sender;
          player.openInventory(inventory);
        } else {
            sender.sendMessage(ChatColor.RED + "You need to be a player to use this command!");
        }

        return false;
    }
}
