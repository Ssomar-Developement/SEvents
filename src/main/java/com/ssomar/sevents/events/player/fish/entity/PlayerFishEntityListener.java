package com.ssomar.sevents.events.player.fish.entity;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

public class PlayerFishEntityListener implements Listener {

    @EventHandler
    public void onPlayerFishEvent(PlayerFishEvent e) {

        if(e.getState().equals(PlayerFishEvent.State.CAUGHT_ENTITY)) {
            Entity ent = e.getCaught();
            if(!(ent instanceof Player)) {
                PlayerFishEntityEvent playerFishEntityEvent = new PlayerFishEntityEvent((Player) e.getPlayer(), ent);
                Bukkit.getServer().getPluginManager().callEvent(playerFishEntityEvent);
                if (playerFishEntityEvent.isCancelled()) {
                    e.setCancelled(true);
                }
            }
        }
    }
}
