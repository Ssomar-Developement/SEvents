package com.ssomar.sevents.events.player.sneak.desactive;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class PlayerDesactiveSneakListener implements Listener {

    @EventHandler
    public void onPlayerToggleSneakEvent(PlayerToggleSneakEvent e) {
        if (!e.isSneaking()) {
            PlayerDesactiveSneakEvent playerDesactiveSneakEvent = new PlayerDesactiveSneakEvent((Player) e.getPlayer());
            Bukkit.getServer().getPluginManager().callEvent(playerDesactiveSneakEvent);
            if (playerDesactiveSneakEvent.isCancelled()) {
                e.setCancelled(true);
            }
        }
    }
}
