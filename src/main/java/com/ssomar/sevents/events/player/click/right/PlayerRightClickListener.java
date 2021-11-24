package com.ssomar.sevents.events.player.click.right;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class PlayerRightClickListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void playerInteractEvent(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        Action action = e.getAction();
        if(action.equals(Action.PHYSICAL)) return;

        EquipmentSlot equipSlot = e.getHand();
        if(equipSlot == null || (equipSlot.equals(EquipmentSlot.OFF_HAND))) {
            /* important pour que le right clik en off hand soit compté*/
            if(!(p.getInventory().getItemInMainHand().getType().equals(Material.AIR) && action.toString().contains("AIR")))
                return;
        }

        if(!(action.equals(Action.LEFT_CLICK_AIR) || action.equals(Action.LEFT_CLICK_BLOCK))) {
            PlayerRightClickEvent playerRightClickEvent = new PlayerRightClickEvent((Player) e.getPlayer(), e.getClickedBlock());
            Bukkit.getServer().getPluginManager().callEvent(playerRightClickEvent);
            if (playerRightClickEvent.isCancelled()) {
                e.setCancelled(true);
            }
        }

    }
}
