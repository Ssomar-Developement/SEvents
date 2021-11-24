package com.ssomar.sevents.events.player.click.onplayer.right;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.ArrayList;
import java.util.List;

public class PlayerRightClickOnPlayerListener implements Listener {

    @EventHandler
    public void onPlayerInteractEntityEvent(PlayerInteractEntityEvent e) {

        if(e.getHand().equals(EquipmentSlot.OFF_HAND)) return;

        if(e.getRightClicked() instanceof Player) {
            PlayerRightClickOnPlayerEvent playerRightClickOnPlayerEvent = new PlayerRightClickOnPlayerEvent((Player) e.getPlayer(), (Player) e.getRightClicked());
            Bukkit.getServer().getPluginManager().callEvent(playerRightClickOnPlayerEvent);
            if (playerRightClickOnPlayerEvent.isCancelled()) {
                e.setCancelled(true);
            }
        }
    }
}
