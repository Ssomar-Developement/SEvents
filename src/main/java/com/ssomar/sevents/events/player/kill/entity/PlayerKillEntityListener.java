package com.ssomar.sevents.events.player.kill.entity;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class PlayerKillEntityListener implements Listener {

    @EventHandler
    public void onEntityDeathEvent(EntityDeathEvent e) {

        if (e.getEntity() instanceof Player) return;

        Player p;
        if ((p = e.getEntity().getKiller()) != null) {
            PlayerKillEntityEvent playerKillEntityEvent = new PlayerKillEntityEvent(p, e.getEntity(), e.getDroppedExp(), e.getDrops());
            Bukkit.getServer().getPluginManager().callEvent(playerKillEntityEvent);
            e.setDroppedExp(playerKillEntityEvent.getDroppedExp());
        }
    }
}
