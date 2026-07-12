package com.ssomar.sevents.events.player.click;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.UUID;

/**
 * Safety net: clears any leftover interaction marker when a player disconnects.
 * The self-heal in {@link InteractionMarkerManager} already prevents markers from
 * outliving their tick; this guarantees no per-player state lingers after a quit
 * even in edge cases where the scheduler could not run (e.g. quit mid-shutdown).
 */
public class InteractionMarkerQuitListener implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void onQuit(PlayerQuitEvent e) {
        UUID pUUID = e.getPlayer().getUniqueId();
        TransmitCancelInteractionManager.getInstance().remove(pUUID);
        TooManyInteractionManager.getInstance().remove(pUUID);
        CancelOffHandInteractionManager.getInstance().remove(pUUID);
    }
}
