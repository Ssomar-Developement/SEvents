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

        //ignore fake events / required to ignore retard event from MythicLib io/lumine/mythic/lib/listener/SkillTriggers.java
        if(e.getDamage() == 0) return;

        if(!(e.getEntity() instanceof Player)) return;

        PlayerReceiveHitGlobalEvent playerReceiveHitGlobalEvent = new PlayerReceiveHitGlobalEvent((Player) e.getEntity(), e.getCause());
        playerReceiveHitGlobalEvent.setCancelled(e.isCancelled());
        Bukkit.getServer().getPluginManager().callEvent(playerReceiveHitGlobalEvent);
        if (playerReceiveHitGlobalEvent.isCancelled()) {
            e.setCancelled(true);
        }
    }
}
