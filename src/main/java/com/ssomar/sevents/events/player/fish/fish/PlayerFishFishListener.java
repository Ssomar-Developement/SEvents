package com.ssomar.sevents.events.player.fish.fish;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

public class PlayerFishFishListener implements Listener {

    @EventHandler(priority = EventPriority.HIGH,ignoreCancelled = true)
    public void onPlayerFishEvent(PlayerFishEvent e) {

        if (e.getState().equals(PlayerFishEvent.State.CAUGHT_FISH)) {
            PlayerFishFishEvent playerFishFishEvent = new PlayerFishFishEvent((Player) e.getPlayer(), e.getCaught(), e.getExpToDrop());
            Bukkit.getServer().getPluginManager().callEvent(playerFishFishEvent);
            if (playerFishFishEvent.getCaught().isDead()) e.getCaught().remove();
            e.setExpToDrop(playerFishFishEvent.getAmount());
            if (playerFishFishEvent.isCancelled()) {
                e.setCancelled(true);
            }
        }
    }
}
