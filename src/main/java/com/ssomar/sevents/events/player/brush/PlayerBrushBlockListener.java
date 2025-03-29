package com.ssomar.sevents.events.player.brush;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Brushable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerBrushBlockListener implements Listener {

    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent e) {

        Action action = e.getAction();
        if (action.equals(Action.RIGHT_CLICK_BLOCK)) {
            Block block = e.getClickedBlock();
            if (block == null && !(block.getBlockData() instanceof Brushable)) return;

            ItemStack item = e.getItem();
            if (item == null || item.getType() != Material.BRUSH) return;


            PlayerBrushBlockEvent playerBrushBlockEvent = new PlayerBrushBlockEvent(e.getPlayer(), e.getClickedBlock());
            playerBrushBlockEvent.setCancelled(e.isCancelled());
            Bukkit.getServer().getPluginManager().callEvent(playerBrushBlockEvent);
            if (playerBrushBlockEvent.isCancelled()) {
                e.setCancelled(true);
            }
        }
    }
}
