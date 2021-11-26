package com.ssomar.sevents.events.projectile.hitenttity;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class ProjectileHitEntityListener implements Listener {

    @EventHandler
    public void onProjectileHitEvent(ProjectileHitEvent e) {
        Entity projectile = e.getEntity();
        Entity target;

        /* PROJECTILE_HIT_BLOCK PART */
        if ((target = e.getHitEntity()) != null && !(target instanceof Player)) {
            Block b = e.getHitBlock();
            ProjectileHitEntityEvent projectileHitEntityEvent = new ProjectileHitEntityEvent(projectile, target);
            Bukkit.getServer().getPluginManager().callEvent(projectileHitEntityEvent);
            if (projectileHitEntityEvent.isCancelled()) {
                e.setCancelled(true);
            }
        }
    }
}
