package com.ssomar.sevents.events.player.sprint.active;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.event.player.PlayerToggleSprintEvent;

public class PlayerActiveSprintListener implements Listener {

    @EventHandler
    public void onPlayerToggleSprintEvent(PlayerToggleSprintEvent e) {
        if (e.isSprinting()) {
            PlayerActiveSprintEvent playerActiveSprintEvent = new PlayerActiveSprintEvent((Player) e.getPlayer());
            Bukkit.getServer().getPluginManager().callEvent(playerActiveSprintEvent);
            if (playerActiveSprintEvent.isCancelled()) {
                e.setCancelled(true);
            }
        }
    }
}
