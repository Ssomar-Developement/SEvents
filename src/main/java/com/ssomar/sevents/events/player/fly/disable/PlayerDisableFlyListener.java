package com.ssomar.sevents.events.player.fly.disable;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;

public class PlayerDisableFlyListener implements Listener {

    @EventHandler
    public void onPlayerToggleFlightEvent(PlayerToggleFlightEvent e) {
        if(!e.isFlying()){
            PlayerDisableFlyEvent playerDesactiveFlyEvent = new PlayerDisableFlyEvent((Player) e.getPlayer());
            playerDesactiveFlyEvent.setCancelled(e.isCancelled());
            Bukkit.getServer().getPluginManager().callEvent(playerDesactiveFlyEvent);
            if (playerDesactiveFlyEvent.isCancelled()) {
                e.setCancelled(true);
            }
        }
    }
}
