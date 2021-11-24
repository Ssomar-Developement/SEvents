package com.ssomar.sevents.events.player.sprint.desactive;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.event.player.PlayerToggleSprintEvent;

public class PlayerDesactiveSprintListener implements Listener {

    @EventHandler
    public void onPlayerToggleSprintEvent(PlayerToggleSprintEvent e) {
        if (!e.isSprinting()) {
            PlayerDesactiveSprintEvent playerDesactiveSprintEvent = new PlayerDesactiveSprintEvent((Player) e.getPlayer());
            Bukkit.getServer().getPluginManager().callEvent(playerDesactiveSprintEvent);
            if (playerDesactiveSprintEvent.isCancelled()) {
                e.setCancelled(true);
            }
        }
    }
}
