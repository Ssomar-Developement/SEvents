package com.ssomar.sevents.events.player.kill.player.participate.entity;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class EntityParticipateKillPlayerListener implements Listener {

    private final HashMap<UUID, List<UUID>> participations = new HashMap<>();

    @EventHandler
    public void onPlayerDeathEvent(PlayerDeathEvent e) {
        Player p = e.getEntity();

        if (participations.containsKey(p.getUniqueId())) {
            List<UUID> list = participations.get(p.getUniqueId());
            for (UUID uuid : list) {
                Entity entity = Bukkit.getEntity(uuid);
                if (entity == null) continue;
                EntityParticipateKillPlayerEvent playerKillPlayerEvent = new EntityParticipateKillPlayerEvent(entity, p);
                Bukkit.getServer().getPluginManager().callEvent(playerKillPlayerEvent);
            }
        }
    }

    @EventHandler
    public void onEntityDamagePlayerEvent(EntityDamageByEntityEvent e) {
        if (!(e.getDamager() instanceof Player) && e.getEntity() instanceof Player) {
            Entity damager = e.getDamager();
            Player damagee = (Player) e.getEntity();
            addParticipation(damager.getUniqueId(), damagee.getUniqueId());
        }
    }

    public void addParticipation(UUID damager, UUID damagee) {
        if (participations.containsKey(damagee)) {
            List<UUID> list = participations.get(damagee);
            if (list.contains(damager)) return;
            list.add(damager);
            participations.put(damagee, list);
        } else {
            List<UUID> list = new ArrayList<>();
            list.add(damager);
            participations.put(damagee, list);
        }
    }
}
