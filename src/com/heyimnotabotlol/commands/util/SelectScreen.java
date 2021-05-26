package com.heyimnotabotlol.commands.util;

import com.heyimnotabotlol.inventories.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

public class SelectScreen implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return true;

        Player player = (Player) sender;

        SelectionScreen gui = new SelectionScreen();
        player.openInventory(gui.getInventory());
        return false;
    }
}
