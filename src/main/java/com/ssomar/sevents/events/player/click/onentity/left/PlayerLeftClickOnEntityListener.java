package com.ssomar.sevents.events.player.click.onentity.left;

import com.ssomar.sevents.events.player.click.onplayer.left.PlayerLeftClickOnPlayerEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerLeftClickOnEntityListener implements Listener {

    @EventHandler
    public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player) {
            if (!(e.getEntity() instanceof Player)) {
                PlayerLeftClickOnEntityEvent playerLeftClickOnEntityEvent = new PlayerLeftClickOnEntityEvent((Player) e.getDamager(), e.getEntity());
                Bukkit.getServer().getPluginManager().callEvent(playerLeftClickOnEntityEvent);
                if (playerLeftClickOnEntityEvent.isCancelled()) {
                    e.setCancelled(true);
                }
            }
        }
    }
}
