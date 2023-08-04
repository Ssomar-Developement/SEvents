package com.ssomar.sevents.events.player.beforedeath.entity;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityBeforeDeathListener implements Listener {

    @EventHandler
    public void onEntityDamageEvent(EntityDamageEvent e) {

        if((e.getEntity() instanceof Player) && e.getEntity() instanceof LivingEntity) return;

        LivingEntity entity = (LivingEntity) e.getEntity();

        if (entity.getHealth() <= e.getFinalDamage()) {
            EntityBeforeDeathEvent entityBeforeDeathEvent = new EntityBeforeDeathEvent(entity);
            Bukkit.getServer().getPluginManager().callEvent(entityBeforeDeathEvent);
            if (entityBeforeDeathEvent.isCancelled()) {
                e.setCancelled(true);
            };
        }
    }
}
