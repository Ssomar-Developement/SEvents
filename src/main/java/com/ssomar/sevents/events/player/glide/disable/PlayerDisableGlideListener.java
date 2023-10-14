package com.ssomar.sevents.events.player.glide.disable;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleGlideEvent;

public class PlayerDisableGlideListener implements Listener {

    @EventHandler
    public void onPlayerToggleFlightEvent(EntityToggleGlideEvent e) {
        if(!(e.getEntity() instanceof Player)) return;
        if(!e.isGliding()){
            PlayerDisableGlideEvent playerDisableGlideEvent = new PlayerDisableGlideEvent((Player) e.getEntity());
            Bukkit.getServer().getPluginManager().callEvent(playerDisableGlideEvent);
            if (playerDisableGlideEvent.isCancelled()) {
                e.setCancelled(true);
            }
        }
    }
}
