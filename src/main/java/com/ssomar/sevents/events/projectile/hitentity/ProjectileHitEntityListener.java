package com.ssomar.sevents.events.projectile.hitentity;

import com.ssomar.sevents.version.Version;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

import java.util.List;

public class ProjectileHitEntityListener implements Listener {

    @EventHandler
    public void onProjectileHitEvent(ProjectileHitEvent e) {
        Entity projectile = e.getEntity();
        Entity target;
 
        if(!Version.is1v11Less()) {
            /* PROJECTILE_HIT_BLOCK PART */
            if ((target = e.getHitEntity()) != null && !(target instanceof Player)) {
                ProjectileHitEntityEvent projectileHitEntityEvent = new ProjectileHitEntityEvent(projectile, target);
                Bukkit.getServer().getPluginManager().callEvent(projectileHitEntityEvent);
                if (projectileHitEntityEvent.isCancelled()) {
                    e.setCancelled(true);
                }
            }
        } else {
            List<Entity> nearbyEntities = projectile.getNearbyEntities(0.7, 0.7, 0.7);
            if(nearbyEntities.size() > 0) {
                for(Entity entity : nearbyEntities) {
                    if(!(entity instanceof Player)) {
                        target = entity;
                        ProjectileHitEntityEvent projectileHitEntityEvent = new ProjectileHitEntityEvent(projectile, target);
                        Bukkit.getServer().getPluginManager().callEvent(projectileHitEntityEvent);
                        if (projectileHitEntityEvent.isCancelled()) {
                            e.setCancelled(true);
                        }
                        return;
                    }
                }
            }
        }
    }
}
