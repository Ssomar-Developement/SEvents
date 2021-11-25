package com.ssomar.sevents.events.player.fly.active;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import java.util.ArrayList;

public class PlayerActiveFlyListener implements Listener {

    @EventHandler
    public void onPlayerToggleFlightEvent(PlayerToggleFlightEvent e) {
        if(e.isFlying()){
            PlayerActiveFlyEvent playerActiveFlyEvent = new PlayerActiveFlyEvent((Player) e.getPlayer());
            Bukkit.getServer().getPluginManager().callEvent(playerActiveFlyEvent);
            if (playerActiveFlyEvent.isCancelled()) {
                e.setCancelled(true);
            }
        }
    }
}
