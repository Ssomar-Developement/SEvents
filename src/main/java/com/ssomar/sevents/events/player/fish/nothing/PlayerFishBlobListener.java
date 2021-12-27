package com.ssomar.sevents.events.player.fish.nothing;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

public class PlayerFishBlobListener implements Listener {

    @EventHandler
    public void onPlayerFishEvent(PlayerFishEvent e) {

        if (e.getState().equals(PlayerFishEvent.State.REEL_IN)) {
            PlayerFishNothingEvent playerFishNothingEvent = new PlayerFishNothingEvent((Player) e.getPlayer(), e.getHook());
            Bukkit.getServer().getPluginManager().callEvent(playerFishNothingEvent);
            if (playerFishNothingEvent.isCancelled()) {
                e.setCancelled(true);
            }
        }
    }
}
