package com.ssomar.sevents.events.player.kill.entity.participate.player;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class PlayerParticipateKillEntityListener implements Listener {

    private final HashMap<UUID, List<UUID>> participations = new HashMap<>();

    @EventHandler
    public void onEntityDeathEvent(EntityDeathEvent e) {
        if ((e.getEntity() instanceof Player)) return;
        Entity ent = e.getEntity();

        if (participations.containsKey(ent.getUniqueId())) {
            List<UUID> list = participations.get(ent.getUniqueId());
            for (UUID uuid : list) {
                PlayerParticipateKillEntityEvent playerKillPlayerEvent = new PlayerParticipateKillEntityEvent(Bukkit.getPlayer(uuid), ent);
                Bukkit.getServer().getPluginManager().callEvent(playerKillPlayerEvent);
            }
        }
        participations.remove(ent.getUniqueId());
    }

    @EventHandler
    public void onPlayerDamageEntityEvent(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player && !(e.getEntity() instanceof Player)) {
            Player damager = (Player) e.getDamager();
            Entity damagee = e.getEntity();
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
