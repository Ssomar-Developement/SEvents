package com.ssomar.sevents.events.player.fly.enable;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;

public class PlayerEnableFlyListener implements Listener {

    @EventHandler
    public void onPlayerToggleFlightEvent(PlayerToggleFlightEvent e) {
        if(e.isFlying()){
            PlayerEnableFlyEvent playerActiveFlyEvent = new PlayerEnableFlyEvent((Player) e.getPlayer());
            playerActiveFlyEvent.setCancelled(e.isCancelled());
            Bukkit.getServer().getPluginManager().callEvent(playerActiveFlyEvent);
            if (playerActiveFlyEvent.isCancelled()) {
                e.setCancelled(true);
            }
        }
    }
}
