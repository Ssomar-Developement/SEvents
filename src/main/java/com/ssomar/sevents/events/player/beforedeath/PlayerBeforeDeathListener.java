package com.ssomar.sevents.events.player.beforedeath;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.ArrayList;

public class PlayerBeforeDeathListener implements Listener {

    @EventHandler
    public void onEntityDamageEvent(EntityDamageEvent e) {

        if(!(e.getEntity() instanceof Player)) return;

        Player p = (Player)e.getEntity();

        if (p.getHealth() <= e.getDamage()) {
            PlayerBeforeDeathEvent playerBeforeDeathEvent = new PlayerBeforeDeathEvent(p);
            Bukkit.getServer().getPluginManager().callEvent(playerBeforeDeathEvent);
            if (playerBeforeDeathEvent.isCancelled()) {
                e.setCancelled(true);
            };
        }
    }
}
