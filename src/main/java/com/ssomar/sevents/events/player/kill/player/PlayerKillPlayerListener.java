package com.ssomar.sevents.events.player.kill.player;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerKillPlayerListener implements Listener {

    @EventHandler
    public void onPlayerDeathEvent(PlayerDeathEvent e) {
        Player p = e.getEntity();
        if (p.getKiller() != null) {
            PlayerKillPlayerEvent playerKillPlayerEvent = new PlayerKillPlayerEvent(p.getKiller(), p, e.getDroppedExp(), e.getDrops());
            Bukkit.getServer().getPluginManager().callEvent(playerKillPlayerEvent);
            e.setDroppedExp(playerKillPlayerEvent.getDroppedExp());
        }
    }
}
