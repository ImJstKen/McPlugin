package com.heyimnotabotlol.commands.misc;

import com.heyimnotabotlol.*;
import com.heyimnotabotlol.timer.*;
import org.bukkit.*;
import org.bukkit.command.*;

public class TimerCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.isOp()) return true;

        if (args.length == 0) {
            sendUsage(sender);
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "resume":
            case "r" : {
                Timer timer = Main.getInstance().getTimer();

                if (timer.isRunning()) {
                    sender.sendMessage("The timer is already running!");
                    break;
                }
                timer.setRunning(true);
                sender.sendMessage("The timer has been started!");
                break;
            }
            case "pause":
            case "p": {
                Timer timer = Main.getInstance().getTimer();
                if (!timer.isRunning()) {
                    sender.sendMessage("The timer is not running!");
                    break;
                }
                timer.setRunning(false);
                sender.sendMessage("The timer has been stopped!");
                break;
            }
            case "time":
            case "t": {
                if (args.length != 2) {
                    sendUsage(sender);
                    return true;
                }

                try {
                    Timer timer = Main.getInstance().getTimer();

                    timer.setRunning(false);
                    timer.setTime(Integer.parseInt(args[1]));
                    sender.sendMessage(ChatColor.GREEN + "The timer has been put to " + ChatColor.AQUA + args[1]);
                } catch (NumberFormatException e) {
                    sender.sendMessage(ChatColor.RED + "Your second argument needs to be a number!");
                }
                break;
            }
            case "reset":
            case "re": {
                Timer timer = Main.getInstance().getTimer();

                timer.setRunning(false);
                timer.setTime(0);
                sender.sendMessage("The timer has been resetted!");
                break;
            }
            default: {
                sendUsage(sender);
            }
        }

        return false;
    }

    private void sendUsage(CommandSender sender) {
        sender.sendMessage(ChatColor.RED + "Invalid syntax! Please use " + ChatColor.YELLOW + "\"/timer [ resume, pause, time <time>, reset ]\"");
    }
}
