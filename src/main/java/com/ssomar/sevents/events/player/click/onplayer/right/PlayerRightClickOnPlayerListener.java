package com.ssomar.sevents.events.player.click.onplayer.right;

import com.ssomar.sevents.events.player.click.onentity.left.PlayerLeftClickOnEntityEvent;
import com.ssomar.sevents.events.player.click.onentity.right.PlayerRightClickOnEntityEvent;
import com.ssomar.sevents.version.Version;
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

        if(!Version.is1v11Less() && e.getHand().equals(EquipmentSlot.OFF_HAND)) return;

        if(e.getRightClicked() instanceof Player) {

            /* NPC is not a player O_o */
            if (e.getRightClicked().hasMetadata("NPC")){
                PlayerRightClickOnEntityEvent playerRightClickOnEntityEvent = new PlayerRightClickOnEntityEvent((Player) e.getPlayer(), e.getRightClicked());
                Bukkit.getServer().getPluginManager().callEvent(playerRightClickOnEntityEvent);
                if (playerRightClickOnEntityEvent.isCancelled()) {
                    e.setCancelled(true);
                }
            }
            else {
                PlayerRightClickOnPlayerEvent playerRightClickOnPlayerEvent = new PlayerRightClickOnPlayerEvent((Player) e.getPlayer(), (Player) e.getRightClicked());
                Bukkit.getServer().getPluginManager().callEvent(playerRightClickOnPlayerEvent);
                if (playerRightClickOnPlayerEvent.isCancelled()) {
                    e.setCancelled(true);
                }
            }
        }
    }
}
