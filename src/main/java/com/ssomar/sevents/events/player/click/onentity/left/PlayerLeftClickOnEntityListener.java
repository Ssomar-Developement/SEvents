package com.ssomar.sevents.events.player.click.onentity.left;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Hanging;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;

public class PlayerLeftClickOnEntityListener implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent e) {

        if (e.getCause().equals(EntityDamageEvent.DamageCause.THORNS) || e.getDamage() == 0) return;

        if (e.getDamager() instanceof Player) {
            Player damager = (Player) e.getDamager();
            if (damager.hasMetadata("cancelDamageEvent"))
                return;

            if (!(e.getEntity() instanceof Player)) {
                PlayerLeftClickOnEntityEvent playerLeftClickOnEntityEvent = new PlayerLeftClickOnEntityEvent((Player) e.getDamager(), e.getEntity());
                Bukkit.getServer().getPluginManager().callEvent(playerLeftClickOnEntityEvent);
                if (playerLeftClickOnEntityEvent.isCancelled()) {
                    e.setCancelled(true);
                }
            }
        }

    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onHangingBreakByEntityEvent(HangingBreakByEntityEvent e) {
        Entity damager = e.getRemover();
        if (damager instanceof Player) {
            if (damager.hasMetadata("cancelDamageEvent"))
                return;
            PlayerLeftClickOnEntityEvent playerLeftClickOnEntityEvent = new PlayerLeftClickOnEntityEvent((Player) e.getRemover(), e.getEntity());
            Bukkit.getServer().getPluginManager().callEvent(playerLeftClickOnEntityEvent);
            if (playerLeftClickOnEntityEvent.isCancelled()) {
                e.setCancelled(true);
            }
        }
    }
}
