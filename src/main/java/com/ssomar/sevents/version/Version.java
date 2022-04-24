package com.ssomar.sevents.version;

import org.bukkit.Bukkit;

public enum Version {
    _1_8,
    _1_9,
    _1_10,
    _1_11,
    _1_12,
    _1_13,
    _1_14,
    _1_15,
    _1_16,
    _1_17,
    _1_18;

    public boolean is(){
        switch (this){
            case _1_8:
                return Bukkit.getServer().getVersion().contains("1.8");
            case _1_9:
                return Bukkit.getServer().getVersion().contains("1.9");
            case _1_10:
                return Bukkit.getServer().getVersion().contains("1.10");
            case _1_11:
                return Bukkit.getServer().getVersion().contains("1.11");
            case _1_12:
                return Bukkit.getServer().getVersion().contains("1.12");
            case _1_13:
                return Bukkit.getServer().getVersion().contains("1.13");
            case _1_14:
                return Bukkit.getServer().getVersion().contains("1.14");
            case _1_15:
                return Bukkit.getServer().getVersion().contains("1.15");
            case _1_16:
                return Bukkit.getServer().getVersion().contains("1.16");
            case _1_17:
                return Bukkit.getServer().getVersion().contains("1.17");
            case _1_18:
                return Bukkit.getServer().getVersion().contains("1.18");
            default:
                return false;
        }
    }
}
