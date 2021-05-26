package com.heyimnotabotlol.commands.fun;

import org.bukkit.command.*;
import org.bukkit.entity.*;

import java.util.*;

public class FlyCommand implements CommandExecutor {

    private ArrayList<Player> flyPlayers = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return true;

        Player player = (Player) sender;

        if (player.isOp()) {
            if (flyPlayers.contains(player)) {
                flyPlayers.remove(player);
                player.setAllowFlight(false);
            } else {
                flyPlayers.add(player);
                player.setAllowFlight(true);
            }
        }

        return false;
    }
}
