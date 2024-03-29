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

        if(!Version.is1v11Less()) {
            /* PROJECTILE_HIT_BLOCK PART */
            if ((target = e.getHitEntity()) != null && target instanceof Player) {
                /* NPC is not a player O_o */
                if (e.getEntity().hasMetadata("NPC")){
                    ProjectileHitEntityEvent projectileHitEntityEvent = new ProjectileHitEntityEvent(projectile, target);
                    if(!Version.is1v12Less()) projectileHitEntityEvent.setCancelled(e.isCancelled());
                    Bukkit.getServer().getPluginManager().callEvent(projectileHitEntityEvent);
                    if (projectileHitEntityEvent.isCancelled() && !Version.is1v12Less()) {
                        e.setCancelled(true);
                    }
                }
                else {
                    ProjectileHitPlayerEvent projectileHitPlayerEvent = new ProjectileHitPlayerEvent(projectile, (Player) target);
                    if(!Version.is1v12Less())  projectileHitPlayerEvent.setCancelled(e.isCancelled());
                    Bukkit.getServer().getPluginManager().callEvent(projectileHitPlayerEvent);
                    if (projectileHitPlayerEvent.isCancelled() && !Version.is1v12Less()) {
                        e.setCancelled(true);
                    }
                }
            }
        }
        else {
            List<Entity> nearbyEntities = projectile.getNearbyEntities(0.7, 0.7, 0.7);
            if(nearbyEntities.size() > 0) {
                for(Entity entity : nearbyEntities) {
                    if(entity instanceof Player) {
                        target = entity;
                        ProjectileHitPlayerEvent projectileHitPlayerEvent = new ProjectileHitPlayerEvent(projectile, (Player) target);
                        if(!Version.is1v12Less()) projectileHitPlayerEvent.setCancelled(e.isCancelled());
                        Bukkit.getServer().getPluginManager().callEvent(projectileHitPlayerEvent);
                        if (projectileHitPlayerEvent.isCancelled() && !Version.is1v12Less()) {
                            e.setCancelled(true);
                        }
                        return;
                    }
                }
            }
        }
    }
}
