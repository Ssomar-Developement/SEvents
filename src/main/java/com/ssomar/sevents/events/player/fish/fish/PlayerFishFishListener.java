package com.ssomar.sevents.events.player.fish.fish;

import com.ssomar.sevents.events.player.fish.player.PlayerFishPlayerEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

public class PlayerFishFishListener implements Listener {

    @EventHandler
    public void onPlayerFishEvent(PlayerFishEvent e) {

        if (e.getState().equals(PlayerFishEvent.State.CAUGHT_FISH)) {
            PlayerFishFishEvent playerFishFishEvent = new PlayerFishFishEvent((Player) e.getPlayer(), e.getCaught());
            Bukkit.getServer().getPluginManager().callEvent(playerFishFishEvent);
            if (playerFishFishEvent.isCancelled()) {
                e.setCancelled(true);
            }
        }
    }
}
