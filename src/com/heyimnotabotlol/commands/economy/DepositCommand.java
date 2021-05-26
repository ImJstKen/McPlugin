package com.heyimnotabotlol.commands.economy;

import com.heyimnotabotlol.*;
import net.milkbowl.vault.economy.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

public class DepositCommand implements CommandExecutor {

    private Economy eco = Main.economy;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) return true;

        Player player = (Player) sender;

        if (args.length == 1) {
            try {
                int depositAmount = Integer.parseInt(args[0]);

                if (eco.hasAccount(player) && eco.getBalance(player) <= depositAmount) {
                    eco.depositPlayer(player, depositAmount);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return false;
    }
}
