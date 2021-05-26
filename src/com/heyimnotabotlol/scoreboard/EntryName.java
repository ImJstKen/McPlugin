package com.heyimnotabotlol.scoreboard;

import org.bukkit.*;

public enum EntryName {

    ENTRY_0(0, ChatColor.AQUA.toString()),
    ENTRY_1(0, ChatColor.YELLOW.toString()),
    ENTRY_2(0, ChatColor.BOLD.toString()),
    ENTRY_3(0, ChatColor.DARK_GRAY.toString()),
    ENTRY_4(0, ChatColor.RED.toString()),
    ENTRY_5(0, ChatColor.GREEN.toString()),
    ENTRY_6(0, ChatColor.DARK_RED.toString()),
    ENTRY_7(0, ChatColor.BLACK.toString()),
    ENTRY_8(0, ChatColor.BLUE.toString()),
    ENTRY_9(0, ChatColor.LIGHT_PURPLE.toString());

    private final int entry;
    private final String entryName;

    EntryName(int entry, String entryName) {
        this.entry = entry;
        this.entryName = entryName;
    }

    public int getEntry() {
        return entry;
    }

    public String getEntryName() {
        return entryName;
    }
}
