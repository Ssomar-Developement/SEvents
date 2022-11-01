package com.ssomar.sevents.events.player.click.onentity.right;

import com.ssomar.sevents.events.player.click.CancelOffHandInteractionManager;
import com.ssomar.sevents.events.player.click.TooManyInteractionManager;
import com.ssomar.sevents.events.player.click.onentity.left.PlayerLeftClickOnEntityEvent;
import com.ssomar.sevents.version.Version;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PlayerRightClickOnEntityListener implements Listener {

    @EventHandler
    public void onPlayerInteractEntityEvent(PlayerInteractEntityEvent e) {

        Player p = e.getPlayer();
        UUID pUUID = p.getUniqueId();

        if(!Version.is1v11Less() && e.getHand().equals(EquipmentSlot.OFF_HAND)) {
            if(CancelOffHandInteractionManager.getInstance().containsKey(pUUID)) {
                CancelOffHandInteractionManager.getInstance().remove(pUUID);
                e.setCancelled(true);
            }
            return;
        }

        if(!(e.getRightClicked() instanceof Player)) {
            PlayerRightClickOnEntityEvent playerRightClickOnEntityEvent = new PlayerRightClickOnEntityEvent((Player) e.getPlayer(), e.getRightClicked());
            Bukkit.getServer().getPluginManager().callEvent(playerRightClickOnEntityEvent);
            if (playerRightClickOnEntityEvent.isCancelled()) {
                e.setCancelled(true);
                CancelOffHandInteractionManager.getInstance().put(pUUID, 1);
            }
            /* Gold on Piglin generates a LEFT_CLICK event */
            if(Version.is1v16Plus() && e.getRightClicked().getType().equals(EntityType.PIGLIN)){
                PlayerInventory pInv = p.getInventory();
                ItemStack item;
                boolean hasGoldInHand = ((item = pInv.getItem(pInv.getHeldItemSlot())) != null || (item = pInv.getItem(40)) != null) && item.getType().equals(Material.GOLD_INGOT);
                if(hasGoldInHand) TooManyInteractionManager.getInstance().put(pUUID, 1);
            }
        }
    }
}
