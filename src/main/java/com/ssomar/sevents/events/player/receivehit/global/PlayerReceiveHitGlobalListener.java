package com.ssomar.sevents.events.player.receivehit.global;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.ArrayList;

public class PlayerReceiveHitGlobalListener implements Listener {

    @EventHandler
    public void onEntityDamageEvent(EntityDamageEvent e) {

        if(!(e.getEntity() instanceof Player)) return;

        PlayerReceiveHitGlobalEvent playerReceiveHitGlobalEvent = new PlayerReceiveHitGlobalEvent((Player) e.getEntity());
        Bukkit.getServer().getPluginManager().callEvent(playerReceiveHitGlobalEvent);
        if (playerReceiveHitGlobalEvent.isCancelled()) {
            e.setCancelled(true);
        }
    }
}
