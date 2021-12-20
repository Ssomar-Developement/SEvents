package com.ssomar.sevents.events.player.press;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Statistic;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerStatisticIncrementEvent;
import org.bukkit.inventory.EquipmentSlot;

public class PlayerPressPlateListener implements Listener {

    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent e) {
        Block block;
        if ((block = e.getClickedBlock()) != null) {
            Action action = e.getAction();

            if (action.equals(Action.PHYSICAL)) {
                if (block.getType().toString().contains("PLATE")) {

                    /* Weighted plate , must have a power equals to 0 to not spam */
                    if (block.getBlockData() instanceof org.bukkit.block.data.AnaloguePowerable) {
                        org.bukkit.block.data.AnaloguePowerable powerable = (org.bukkit.block.data.AnaloguePowerable) block.getBlockData();
                        if (powerable.getPower() != 0) return;
                    }

                    PlayerPressPlateEvent playerPressPlateEvent = new PlayerPressPlateEvent(e.getPlayer(), block);
                    Bukkit.getServer().getPluginManager().callEvent(playerPressPlateEvent);
                }
            }
        }
    }
}
