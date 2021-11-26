package com.ssomar.sevents.events.projectile.hitplayer;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class ProjectileHitPlayerListener implements Listener {

    @EventHandler
    public void onProjectileHitEvent(ProjectileHitEvent e) {
        Entity projectile = e.getEntity();
        Entity target;

        /* PROJECTILE_HIT_BLOCK PART */
        if ((target = e.getHitEntity()) != null && target instanceof Player) {
            Block b = e.getHitBlock();
            ProjectileHitPlayerEvent projectileHitPlayerEvent = new ProjectileHitPlayerEvent(projectile, (Player) target);
            Bukkit.getServer().getPluginManager().callEvent(projectileHitPlayerEvent);
            if (projectileHitPlayerEvent.isCancelled()) {
                e.setCancelled(true);
            }
        }
    }
}
