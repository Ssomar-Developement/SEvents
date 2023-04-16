package com.ssomar.sevents.events.block;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFadeEvent;

public class BlockDryListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBlockFadeEvent(BlockFadeEvent e) {
        Block block = e.getBlock();

        Material newMat = block.getType();
        String newMatStr = newMat.toString();

        if (newMatStr.contains("CORAL") || newMatStr.contains("FARMLAND")) {
            BlockDryEvent playerTrampleCropsEvent = new BlockDryEvent(block);
            Bukkit.getServer().getPluginManager().callEvent(playerTrampleCropsEvent);
            if (playerTrampleCropsEvent.isCancelled()) {
                e.setCancelled(true);
            }
        }
    }
}
