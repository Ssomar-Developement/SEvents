package com.ssomar.sevents.events.player.click.onplayer.left;

import com.ssomar.sevents.events.player.click.EntityDamageByEntityEventExtension;
import com.ssomar.sevents.events.player.click.onplayer.right.PlayerRightClickOnPlayerEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.metadata.MetadataValue;

import java.util.ArrayList;
import java.util.List;

public class PlayerLeftClickOnPlayerListener implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent e) {

        if(e instanceof EntityDamageByEntityEventExtension && ((EntityDamageByEntityEventExtension)e).isAvoidLoop()) return;

        if (e.getDamager() instanceof Player) {
            Player damager = (Player) e.getDamager();

            if (e.getEntity() instanceof Player) {
                PlayerLeftClickOnPlayerEvent playerLeftClickOnPlayerEvent = new PlayerLeftClickOnPlayerEvent(damager, (Player) e.getEntity());
                Bukkit.getServer().getPluginManager().callEvent(playerLeftClickOnPlayerEvent);
                if (playerLeftClickOnPlayerEvent.isCancelled()) {
                    e.setCancelled(true);
                }
            }
        }
    }
}
