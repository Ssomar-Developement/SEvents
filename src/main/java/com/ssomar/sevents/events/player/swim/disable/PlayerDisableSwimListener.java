package com.ssomar.sevents.events.player.swim.disable;

import org.bukkit.Bukkit;
import org.bukkit.entity.Enemy;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleSwimEvent;
import org.bukkit.event.player.PlayerToggleSprintEvent;

public class PlayerDisableSwimListener implements Listener {

    @EventHandler
    public void onPlayerToggleSwimEvent(EntityToggleSwimEvent e) {
        Entity entity = e.getEntity();
        if (entity instanceof Player && !e.isSwimming()) {
            PlayerDisableSwimEvent playerDesactiveSprintEvent = new PlayerDisableSwimEvent((Player) entity);
            playerDesactiveSprintEvent.setCancelled(e.isCancelled());
            Bukkit.getServer().getPluginManager().callEvent(playerDesactiveSprintEvent);
            if (playerDesactiveSprintEvent.isCancelled()) {
                e.setCancelled(true);
            }
        }
    }
}
