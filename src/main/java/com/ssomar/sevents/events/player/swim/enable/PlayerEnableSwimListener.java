package com.ssomar.sevents.events.player.swim.enable;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleSwimEvent;
import org.bukkit.event.player.PlayerToggleSprintEvent;

public class PlayerEnableSwimListener implements Listener {

    @EventHandler
    public void onPlayerToggleSwimEvent(EntityToggleSwimEvent e) {
        Entity entity = e.getEntity();
        if (entity instanceof Player && e.isSwimming()) {
            PlayerEnableSwimEvent playerActiveSprintEvent = new PlayerEnableSwimEvent((Player) entity);
            playerActiveSprintEvent.setCancelled(e.isCancelled());
            Bukkit.getServer().getPluginManager().callEvent(playerActiveSprintEvent);
            if (playerActiveSprintEvent.isCancelled()) {
                e.setCancelled(true);
            }
        }
    }
}
