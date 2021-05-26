package com.heyimnotabotlol.commands.economy;

import com.heyimnotabotlol.*;
import net.milkbowl.vault.economy.*;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

public class BalanceCommand implements CommandExecutor {

    private Economy eco = Main.economy;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) return true;

        Player player = (Player) sender;

        player.sendMessage("Your balance is $" + ChatColor.GREEN + eco.getBalance(player));

        return false;
    }
}
