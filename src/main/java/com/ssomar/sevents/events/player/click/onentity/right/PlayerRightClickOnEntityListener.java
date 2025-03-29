package com.ssomar.sevents.events.player.click.onentity.right;

import com.ssomar.sevents.events.player.click.CancelOffHandInteractionManager;
import com.ssomar.sevents.events.player.click.TooManyInteractionManager;
import com.ssomar.sevents.events.player.click.TransmitCancelInteractionManager;
import com.ssomar.sevents.version.Version;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.*;

public class PlayerRightClickOnEntityListener implements Listener {

    /* PlayerInteractEntityEvent -> removed because it isnt generated with right click armor stand */
    /* PlayerInteractEntityEvent -> BUT IN FACT IT IS NECESSARY BECAUSE PlayerInteractAtEntityEvent doesnt cancel interaction even with canceled true  */
    @EventHandler
    public void onPlayerInteractAtEntityEvent(PlayerInteractAtEntityEvent e) {

        Player p = e.getPlayer();
        UUID pUUID = p.getUniqueId();

        /* when its an object that is interactable with then entity ex: dye on sheep or tamed wolf
         * In main hand -> event MAIN HAND only
         * In off hand -> event MAIN HAND + OFF HAND
         * in main hand and off hand -> event MAIN HAND + OFF HAND
         * When its not
         * In main hand -> MAIN HAND + OFF HAND
         * In off hand -> MAIN HAND + OFF HAND
         * In main hand and off hand -> MAIN HAND + OFF HAND
         * */

        if (!Version.is1v11Less() && e.getHand().equals(EquipmentSlot.OFF_HAND)) {
            if (CancelOffHandInteractionManager.getInstance().containsKey(pUUID)) {
                CancelOffHandInteractionManager.getInstance().remove(pUUID);
                e.setCancelled(true);
                TransmitCancelInteractionManager.getInstance().put(pUUID, 1);
            }
            return;
        }

        if (!(e.getRightClicked() instanceof Player)) {
            PlayerRightClickOnEntityEvent playerRightClickOnEntityEvent = new PlayerRightClickOnEntityEvent((Player) e.getPlayer(), e.getRightClicked());
            playerRightClickOnEntityEvent.setCancelled(e.isCancelled());
            Bukkit.getServer().getPluginManager().callEvent(playerRightClickOnEntityEvent);
            if (playerRightClickOnEntityEvent.isCancelled()) {
                e.setCancelled(true);

                TransmitCancelInteractionManager.getInstance().put(pUUID, 1);

                if (!Version.is1v11Less()) {
                    ItemStack mainHandItem = p.getInventory().getItemInMainHand();
                    if (mainHandItem != null) {
                        if (mainHandItem.getType().toString().toUpperCase().contains("DYE")) {
                            Entity entity = e.getRightClicked();
                            if (entity instanceof Sheep) {
                                Sheep sheep = (Sheep) entity;
                                if (sheep.isSheared()) return;
                            } else if (entity instanceof Wolf) {
                                Wolf wolf = (Wolf) entity;
                                if (!wolf.isTamed()) return;
                            }
                        }
                    }
                    CancelOffHandInteractionManager.getInstance().put(pUUID, 1);
                }
            }
            /* Gold on Piglin generates a LEFT_CLICK event */
            if (Version.is1v16Plus() && e.getRightClicked().getType().equals(EntityType.PIGLIN)) {
                PlayerInventory pInv = p.getInventory();
                ItemStack item;
                boolean hasGoldInHand = ((item = pInv.getItem(pInv.getHeldItemSlot())) != null || (item = pInv.getItem(40)) != null) && item.getType().equals(Material.GOLD_INGOT);
                if (hasGoldInHand) TooManyInteractionManager.getInstance().put(pUUID, 1);
            }
        }
    }

    @EventHandler
    public void onPlayerInteractEntityEvent(PlayerInteractEntityEvent e) {
        Player p = e.getPlayer();
        UUID pUUID = p.getUniqueId();

        if (TransmitCancelInteractionManager.getInstance().containsKey(pUUID)) {
            TransmitCancelInteractionManager.getInstance().remove(pUUID);
            e.setCancelled(true);
        }
    }
}
