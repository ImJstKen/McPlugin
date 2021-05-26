package com.heyimnotabotlol.commands.misc;

import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

public class GamemodeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return true;

        Player player = (Player) sender;

        if (args.length != 2) return true;

        Player target = Bukkit.getPlayer(args[0]);

        if (target == null) return true;

        switch (args[1]) {
            case "s":
            case "survival":
            case "0" : {
                target.setGameMode(GameMode.SURVIVAL);
                break;
            }
            case "c":
            case "creative":
            case "1" : {
                target.setGameMode(GameMode.CREATIVE);
                break;
            }
            case "a":
            case "adventure":
            case "2" : {
                target.setGameMode(GameMode.ADVENTURE);
                break;
            }
            case "sp":
            case "spectator":
            case "3" : {
                target.setGameMode(GameMode.SPECTATOR);
                break;
            }
            default: {
                player.sendMessage(ChatColor.RED + "Invalid syntax! Usage: " + ChatColor.YELLOW + "/gm <player> [ s / survival / 1 | c / creative / 1 | a / adventure / 2 | sp / spectator / 3 ]");
            }
        }

        return false;
    }
}
