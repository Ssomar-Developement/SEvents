package com.ssomar.sevents.events.player.glide.enable;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleGlideEvent;

public class PlayerEnableGlideListener implements Listener {

    @EventHandler
    public void onPlayerToggleFlightEvent(EntityToggleGlideEvent e) {
        if(!(e.getEntity() instanceof Player)) return;
        if(e.isGliding()){
            PlayerEnableGlideEvent playerEnableGlideEvent = new PlayerEnableGlideEvent((Player) e.getEntity());
            Bukkit.getServer().getPluginManager().callEvent(playerEnableGlideEvent);
            if (playerEnableGlideEvent.isCancelled()) {
                e.setCancelled(true);
            }
        }
    }
}
