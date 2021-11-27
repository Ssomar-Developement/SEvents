package com.ssomar.sevents.events.player.click.onentity.right;

import com.ssomar.sevents.events.player.click.TooManyInteractionManager;
import com.ssomar.sevents.events.player.click.onentity.left.PlayerLeftClickOnEntityEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.EnderDragonPart;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.ArrayList;
import java.util.List;

public class PlayerRightClickOnEntityListener implements Listener {

    @EventHandler
    public void onPlayerInteractEntityEvent(PlayerInteractEntityEvent e) {

        if(e.getHand().equals(EquipmentSlot.OFF_HAND)) return;

        if(!(e.getRightClicked() instanceof Player)) {
            PlayerRightClickOnEntityEvent playerRightClickOnEntityEvent = new PlayerRightClickOnEntityEvent((Player) e.getPlayer(), e.getRightClicked());
            Bukkit.getServer().getPluginManager().callEvent(playerRightClickOnEntityEvent);
            if (playerRightClickOnEntityEvent.isCancelled()) {
                e.setCancelled(true);
            }
            /* Gold on Piglin generates a LEFT_CLICK event */
            Player p = e.getPlayer();
            if(p.getInventory().getItem(p.getInventory().getHeldItemSlot()).getType().equals(Material.GOLD_INGOT) && e.getRightClicked().getType().equals(EntityType.PIGLIN)){
                TooManyInteractionManager.getInstance().put(p.getUniqueId(), 1);
            }
        }
    }
}
