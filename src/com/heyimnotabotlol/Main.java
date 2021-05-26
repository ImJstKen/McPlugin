package com.heyimnotabotlol;

import com.heyimnotabotlol.commands.economy.*;
import com.heyimnotabotlol.commands.misc.*;
import com.heyimnotabotlol.commands.fun.*;
import com.heyimnotabotlol.commands.util.*;
import com.heyimnotabotlol.items.*;
import com.heyimnotabotlol.listeners.*;
import com.heyimnotabotlol.timer.*;
import com.heyimnotabotlol.utils.*;
import net.milkbowl.vault.economy.*;
import org.bukkit.*;
import org.bukkit.plugin.*;
import org.bukkit.plugin.java.*;

public class Main extends JavaPlugin {

    public static Economy economy;

    private static Main instance;

    private Timer timer;

    private boolean setupEconomy() {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }

        return (economy != null);
    }

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        if (!setupEconomy()) {
            Bukkit.shutdown();
        }

        new Config();

        System.out.println("Hello world!");

        listenerRegistration();
        commandRegistration();

        timer = new Timer(false, 0);

        ItemManager.init();
    }

    @Override
    public void onDisable() {
        System.out.println("Shutting down..");
    }

    private void listenerRegistration() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new EventListeners(),this);
    }

    private void commandRegistration() {
        getCommand("date").setExecutor(new DateCommand());
        getCommand("vault1").setExecutor(new BackPackCommand());
        getCommand("vault2").setExecutor(new BackPackCommand());
        getCommand("vault3").setExecutor(new BackPackCommand());
        getCommand("vault4").setExecutor(new BackPackCommand());
        getCommand("vault5").setExecutor(new BackPackCommand());
        getCommand("timer").setExecutor(new TimerCommand());
        getCommand("t").setExecutor(new TimerCommand());
        getCommand("giveitem").setExecutor(new GiveItems());
        getCommand("select").setExecutor(new SelectScreen());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("deposit").setExecutor(new DepositCommand());
        getCommand("balance").setExecutor(new BalanceCommand());
    }

    public static Main getInstance() {
        return instance;
    }

    public Timer getTimer() {
        return timer;
    }
}