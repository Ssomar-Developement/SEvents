package com.ssomar.sevents.events.player.sneak.active;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class PlayerActiveSneakListener implements Listener {

    @EventHandler
    public void onPlayerToggleSneakEvent(PlayerToggleSneakEvent e) {
        if (e.isSneaking()) {
            PlayerActiveSneakEvent playerActiveSneakEvent = new PlayerActiveSneakEvent((Player) e.getPlayer());
            Bukkit.getServer().getPluginManager().callEvent(playerActiveSneakEvent);
            if (playerActiveSneakEvent.isCancelled()) {
                e.setCancelled(true);
            }
        }
    }
}
