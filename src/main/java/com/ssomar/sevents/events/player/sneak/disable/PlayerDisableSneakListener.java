package com.ssomar.sevents.events.player.sneak.disable;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class PlayerDisableSneakListener implements Listener {

    @EventHandler
    public void onPlayerToggleSneakEvent(PlayerToggleSneakEvent e) {
        if (!e.isSneaking()) {
            PlayerDisableSneakEvent playerDesactiveSneakEvent = new PlayerDisableSneakEvent((Player) e.getPlayer());
            playerDesactiveSneakEvent.setCancelled(e.isCancelled());
            Bukkit.getServer().getPluginManager().callEvent(playerDesactiveSneakEvent);
            if (playerDesactiveSneakEvent.isCancelled()) {
                e.setCancelled(true);
            }
        }
    }
}
