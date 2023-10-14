package com.ssomar.sevents.events.player.sneak.enable;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class PlayerEnableSneakListener implements Listener {

    @EventHandler
    public void onPlayerToggleSneakEvent(PlayerToggleSneakEvent e) {
        if (e.isSneaking()) {
            PlayerEnableSneakEvent playerActiveSneakEvent = new PlayerEnableSneakEvent((Player) e.getPlayer());
            Bukkit.getServer().getPluginManager().callEvent(playerActiveSneakEvent);
            if (playerActiveSneakEvent.isCancelled()) {
                e.setCancelled(true);
            }
        }
    }
}
