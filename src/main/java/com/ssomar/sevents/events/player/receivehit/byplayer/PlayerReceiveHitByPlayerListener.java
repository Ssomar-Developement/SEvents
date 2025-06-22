package com.ssomar.sevents.events.player.receivehit.byplayer;

import com.ssomar.sevents.events.player.fish.player.PlayerFishPlayerEvent;
import com.ssomar.sevents.events.player.receivehit.byentity.PlayerReceiveHitByEntityEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.metadata.MetadataValue;

import java.util.ArrayList;
import java.util.List;

public class PlayerReceiveHitByPlayerListener implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent e) {

        //ignore fake events / required to ignore fake events
        if(e.getDamage() == 0) return;

        if (e.getDamager() instanceof Player) {
            Player damager = (Player) e.getDamager();
            if(damager.hasMetadata("cancelDamageEvent")){
                return;
            }

            if (e.getEntity() instanceof Player) {
                /* NPC is not a player O_o */
                if (e.getEntity().hasMetadata("NPC")){
                    PlayerReceiveHitByEntityEvent playerReceiveHitByEntityEvent = new PlayerReceiveHitByEntityEvent((Player) e.getEntity(), e.getDamager(), e);
                    playerReceiveHitByEntityEvent.setCancelled(e.isCancelled());
                    Bukkit.getServer().getPluginManager().callEvent(playerReceiveHitByEntityEvent);
                    if (playerReceiveHitByEntityEvent.isCancelled()) {
                        e.setCancelled(true);
                    }
                }else {
                    PlayerReceiveHitByPlayerEvent playerReceiveHitByPlayerEvent = new PlayerReceiveHitByPlayerEvent((Player) e.getEntity(), (Player) e.getDamager(), e);
                    playerReceiveHitByPlayerEvent.setCancelled(e.isCancelled());
                    Bukkit.getServer().getPluginManager().callEvent(playerReceiveHitByPlayerEvent);
                    if (playerReceiveHitByPlayerEvent.isCancelled()) {
                        e.setCancelled(true);
                    }
                }
            }
        }
    }
}
