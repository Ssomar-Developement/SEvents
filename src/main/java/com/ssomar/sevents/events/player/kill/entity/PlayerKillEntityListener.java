package com.ssomar.sevents.events.player.kill.entity;

import org.bukkit.Bukkit;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.vehicle.VehicleDestroyEvent;

import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

public class PlayerKillEntityListener implements Listener {

    private Map<UUID, UUID> playerKilledArmorStand;

    public PlayerKillEntityListener() {
        playerKilledArmorStand = new java.util.HashMap<>();
    }

    @EventHandler
    public void onEntityDeathEvent(EntityDeathEvent e) {

        if (e.getEntity() instanceof Player) return;

        Player p;

        if (e.getEntity() instanceof ArmorStand) {
            if (playerKilledArmorStand.containsKey(e.getEntity().getUniqueId())) {
                p = Bukkit.getPlayer(playerKilledArmorStand.get(e.getEntity().getUniqueId()));
                playerKilledArmorStand.remove(e.getEntity().getUniqueId());
            } else return;
        } else if ((p = e.getEntity().getKiller()) == null) return;

        if (p != null) {
            PlayerKillEntityEvent playerKillEntityEvent = new PlayerKillEntityEvent(p, e.getEntity(), e.getDroppedExp(), e.getDrops());
            Bukkit.getServer().getPluginManager().callEvent(playerKillEntityEvent);
            e.setDroppedExp(playerKillEntityEvent.getDroppedExp());
        }
    }

    @EventHandler
    public void ArmorStandKiller(EntityDamageByEntityEvent e) {

        if (!(e.getEntity() instanceof ArmorStand && e.getDamager() instanceof Player)) return;

        playerKilledArmorStand.put(e.getEntity().getUniqueId(), e.getDamager().getUniqueId());
    }

    // For item frames, paintings, and leashes
    @EventHandler
    public void onHangingBreakByEntityEvent(HangingBreakByEntityEvent e) {

        if (e.getEntity() instanceof Player || !(e.getRemover() instanceof Player)) return;

        Player p;
        if ((p = (Player) e.getRemover()) == null) return;

        if (p != null) {
            PlayerKillEntityEvent playerKillEntityEvent = new PlayerKillEntityEvent(p, e.getEntity(), 0, new ArrayList<>());
            Bukkit.getServer().getPluginManager().callEvent(playerKillEntityEvent);
            if(playerKillEntityEvent.isCancelled()) e.setCancelled(true);
        }
    }

    @EventHandler
    public void onVehicleDestroyEvent(VehicleDestroyEvent e) {

        if (!(e.getAttacker() instanceof Player)) return;

        Player p;
        if ((p = (Player) e.getAttacker()) == null) return;

        if (p != null) {
            PlayerKillEntityEvent playerKillEntityEvent = new PlayerKillEntityEvent(p, e.getVehicle(), 0, new ArrayList<>());
            Bukkit.getServer().getPluginManager().callEvent(playerKillEntityEvent);
            if(playerKillEntityEvent.isCancelled()) e.setCancelled(true);
        }
    }

}