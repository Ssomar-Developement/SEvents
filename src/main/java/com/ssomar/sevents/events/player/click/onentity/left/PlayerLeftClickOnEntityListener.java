package com.ssomar.sevents.events.player.click.onentity.left;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Hanging;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerLeftClickOnEntityListener implements Listener {

    List<EntityType> entity0Damage;

    public PlayerLeftClickOnEntityListener() {
        entity0Damage = new ArrayList<>();
        try{
            entity0Damage.add(EntityType.ITEM_FRAME);
        } catch (Exception | Error e) {}
        try{
            entity0Damage.add(EntityType.GLOW_ITEM_FRAME);
        } catch (Exception | Error e) {}
    }


    @EventHandler(priority = EventPriority.LOWEST)
    public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent e) {

        if (e.getCause().equals(EntityDamageEvent.DamageCause.THORNS) || (e.getDamage() == 0 && !entity0Damage.contains(e.getEntity().getType()))) return;

        if (e.getDamager() instanceof Player) {
            Player damager = (Player) e.getDamager();
            if (damager.hasMetadata("damageFromCustomCommand"))
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

    /* Destroy hanging , like itemframe */
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
