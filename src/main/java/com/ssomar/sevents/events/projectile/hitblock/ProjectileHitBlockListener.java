package com.ssomar.sevents.events.projectile.hitblock;

import com.ssomar.sevents.events.player.click.left.PlayerLeftClickEvent;
import com.ssomar.sevents.version.Version;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.*;

public class ProjectileHitBlockListener implements Listener {

    @EventHandler
    public void onProjectileHitEvent(ProjectileHitEvent e) {
        Entity projectile = e.getEntity();

        /* PROJECTILE_HIT_BLOCK PART */
        if (e.getHitBlock() != null) {
            Block b = e.getHitBlock();
            ProjectileHitBlockEvent projectileHitBlockEvent = new ProjectileHitBlockEvent(projectile, b, e.getHitBlockFace());
            Bukkit.getServer().getPluginManager().callEvent(projectileHitBlockEvent);
            if (projectileHitBlockEvent.isCancelled()) {
                e.setCancelled(true);
            }
        }
    }
}
