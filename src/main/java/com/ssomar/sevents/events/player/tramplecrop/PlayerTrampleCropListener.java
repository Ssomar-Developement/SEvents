package com.ssomar.sevents.events.player.tramplecrop;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.UUID;

public class PlayerTrampleCropListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void playerInteractEvent(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        UUID pUUID = p.getUniqueId();

        Action action = e.getAction();
        if (!action.equals(Action.PHYSICAL)) return;

        if(e.hasBlock()) {
            Block b = e.getClickedBlock();
            if(b.getType().equals(Material.FARMLAND)) {
                PlayerTrampleCropEvent playerTrampleCropsEvent = new PlayerTrampleCropEvent((Player) e.getPlayer(), e.getClickedBlock());
                Bukkit.getServer().getPluginManager().callEvent(playerTrampleCropsEvent);
                if (playerTrampleCropsEvent.isCancelled()) {
                    e.setCancelled(true);
                }
            }
        }
    }
}
