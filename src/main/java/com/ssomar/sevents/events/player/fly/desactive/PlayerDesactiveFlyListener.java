package com.ssomar.sevents.events.player.fly.desactive;

import com.ssomar.sevents.events.player.fly.active.PlayerActiveFlyEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import java.util.ArrayList;

public class PlayerDesactiveFlyListener implements Listener {

    @EventHandler
    public void onPlayerToggleFlightEvent(PlayerToggleFlightEvent e) {
        if(!e.isFlying()){
            PlayerDesactiveFlyEvent playerDesactiveFlyEvent = new PlayerDesactiveFlyEvent((Player) e.getPlayer());
            Bukkit.getServer().getPluginManager().callEvent(playerDesactiveFlyEvent);
            if (playerDesactiveFlyEvent.isCancelled()) {
                e.setCancelled(true);
            }
        }
    }
}
