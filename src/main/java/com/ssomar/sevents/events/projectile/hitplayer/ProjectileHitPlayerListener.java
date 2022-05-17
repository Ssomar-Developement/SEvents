package com.ssomar.sevents.events.projectile.hitplayer;

import com.ssomar.sevents.events.projectile.hitentity.ProjectileHitEntityEvent;
import com.ssomar.sevents.version.Version;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

import java.util.List;

public class ProjectileHitPlayerListener implements Listener {

    @EventHandler
    public void onProjectileHitEvent(ProjectileHitEvent e) {
        Entity projectile = e.getEntity();
        Entity target;

        if(Version.is1v11Less()) {
            /* PROJECTILE_HIT_BLOCK PART */
            if ((target = e.getHitEntity()) != null && target instanceof Player) {
                ProjectileHitPlayerEvent projectileHitPlayerEvent = new ProjectileHitPlayerEvent(projectile, (Player) target);
                Bukkit.getServer().getPluginManager().callEvent(projectileHitPlayerEvent);
                if (projectileHitPlayerEvent.isCancelled()) {
                    e.setCancelled(true);
                }
            }
        }
        else {
            List<Entity> nearbyEntities = projectile.getNearbyEntities(0.7, 0.7, 0.7);
            if(nearbyEntities.size() > 0) {
                for(Entity entity : nearbyEntities) {
                    if(entity instanceof Player) {
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
