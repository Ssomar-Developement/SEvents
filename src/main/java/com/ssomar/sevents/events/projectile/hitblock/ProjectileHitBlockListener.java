package com.ssomar.sevents.events.projectile.hitblock;

import com.ssomar.sevents.version.Version;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class ProjectileHitBlockListener implements Listener {

    @EventHandler
    public void onProjectileHitEvent(ProjectileHitEvent e) {
        Entity projectile = e.getEntity();

        BlockFace blockFace;
        if (Version.is1v12Less()) blockFace = BlockFace.UP;
        else blockFace = e.getHitBlockFace();

        if (!Version.is1v11Less()) {
            /* PROJECTILE_HIT_BLOCK PART */
            if (e.getHitBlock() != null) {
                Block b = e.getHitBlock();
                ProjectileHitBlockEvent projectileHitBlockEvent = new ProjectileHitBlockEvent(projectile, b, blockFace);
                Bukkit.getServer().getPluginManager().callEvent(projectileHitBlockEvent);
                if (projectileHitBlockEvent.isCancelled() && !Version.is1v11Less()) {
                    e.setCancelled(true);
                }
            }
        }
        else{
            if(projectile.isOnGround()){
                Block b = projectile.getLocation().subtract(0,0.2,0).getBlock();
                ProjectileHitBlockEvent projectileHitBlockEvent = new ProjectileHitBlockEvent(projectile, b, blockFace);
                Bukkit.getServer().getPluginManager().callEvent(projectileHitBlockEvent);
                if (projectileHitBlockEvent.isCancelled() && !Version.is1v11Less()) {
                    e.setCancelled(true);
                }
            }
        }
    }
}
