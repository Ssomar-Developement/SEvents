package com.ssomar.sevents.events.player.fish.fish;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

public class PlayerFishFishListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onPlayerFishEvent(PlayerFishEvent e) {

        if (e.getState().equals(PlayerFishEvent.State.CAUGHT_FISH)) {
            Entity caught = e.getCaught();
            if(caught == null) return; // No entity caught, nothing to do
            PlayerFishFishEvent playerFishFishEvent = new PlayerFishFishEvent((Player) e.getPlayer(), caught, e.getExpToDrop());
            playerFishFishEvent.setCancelled(e.isCancelled());
            Bukkit.getServer().getPluginManager().callEvent(playerFishFishEvent);
            if (caught.isDead()) caught.remove();
            e.setExpToDrop(playerFishFishEvent.getAmount());
            if (playerFishFishEvent.isCancelled()) {
                e.setCancelled(true);
            }
        }
    }
}
