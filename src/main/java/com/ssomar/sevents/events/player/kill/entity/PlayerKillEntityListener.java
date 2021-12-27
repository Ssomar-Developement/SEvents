package com.ssomar.sevents.events.player.kill.entity;

import com.ssomar.sevents.events.player.kill.player.PlayerKillPlayerEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.ArrayList;

public class PlayerKillEntityListener implements Listener {

    @EventHandler
    public void onEntityDeathEvent(EntityDeathEvent e) {

        if (e.getEntity() instanceof Player) return;

        Player p;
        if ((p = e.getEntity().getKiller()) != null) {
            PlayerKillEntityEvent playerKillEntityEvent = new PlayerKillEntityEvent(p, e.getEntity());
            Bukkit.getServer().getPluginManager().callEvent(playerKillEntityEvent);
        }
    }
}
