package com.heyimnotabotlol.scoreboard;

import com.heyimnotabotlol.Main;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.scheduler.BukkitRunnable;

public class ScoreBoard extends ScoreBoardBuilder {

    private int socialId;

    public ScoreBoard(Player player) {
        super(player, " Scoreboard ");
        socialId = 0;

        run();
    }

    @Override
    public void createScoreboard() {
        if (player.isOp()) {
            setScore(ChatColor.RED + "Admin", 3);
        } else {
            setScore(ChatColor.AQUA + "Player", 3);
        }

        setScore("Your rank:", 2);
        setScore("Level", 1);
        setScore("Credits", 0);
    }

    @Override
    public void update() {

    }

    private void run() {
        new BukkitRunnable() {
            @Override
            public void run() {

                switch (socialId) {
                    case 0:
                        setScore(ChatColor.AQUA + "twitter.com/DerBanko", 3);
                        break;
                    case 1:
                        setScore(ChatColor.DARK_PURPLE + "twitch.tv/DerBanko", 3);
                        break;
                    case 2:
                        setScore(ChatColor.DARK_RED + "youtube.com/DerBanko", 3);
                        break;
                }
                socialId++;

                if (socialId >= 3) socialId = 0;
            }


        }.runTaskTimer(Main.getInstance(),20,20);
    }

}
