package com.ssomar.sevents.events.player.receivehit.byentity;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PlayerReceiveHitByEntityListener implements Listener {

    @EventHandler
    public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent e) {

        //ignore fake events / required to ignore fake event
        if(e.getDamage() == 0) return;

        if (!(e.getDamager() instanceof Player)) {

            if (e.getEntity() instanceof Player) {
                PlayerReceiveHitByEntityEvent playerReceiveHitByPlayerEvent = new PlayerReceiveHitByEntityEvent((Player) e.getEntity(), e.getDamager(), e);
                playerReceiveHitByPlayerEvent.setCancelled(e.isCancelled());
                Bukkit.getServer().getPluginManager().callEvent(playerReceiveHitByPlayerEvent);
                if (playerReceiveHitByPlayerEvent.isCancelled()) {
                    e.setCancelled(true);
                }
            }
        }
    }
}
