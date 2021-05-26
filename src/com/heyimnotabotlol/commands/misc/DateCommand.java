package com.heyimnotabotlol.commands.misc;

import org.bukkit.command.*;

import java.util.*;

public class DateCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Date date = new Date();
        sender.sendMessage("It's " + date.toString());
        return false;
    }
}