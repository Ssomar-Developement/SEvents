package com.ssomar.sevents.events.player.fish.nothing;

import com.ssomar.sevents.version.Version;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

public class PlayerFishBlobListener implements Listener {

    @EventHandler(priority = EventPriority.HIGH,ignoreCancelled = true)
    public void onPlayerFishEvent(PlayerFishEvent e) {

        /* Not compatible in 1.12 and 1.13 */
        if (!Version.is1v13Less() && e.getState().equals(PlayerFishEvent.State.REEL_IN)) {
            PlayerFishNothingEvent playerFishNothingEvent = new PlayerFishNothingEvent((Player) e.getPlayer(), e.getHook());
            Bukkit.getServer().getPluginManager().callEvent(playerFishNothingEvent);
            if (playerFishNothingEvent.isCancelled()) {
                e.setCancelled(true);
            }
        }
    }
}
