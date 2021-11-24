package com.ssomar.sevents.events.player.click.left;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class PlayerLeftClickListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void playerInteractEvent(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        Action action = e.getAction();
        if(action.equals(Action.PHYSICAL)) return;

        if(action.equals(Action.LEFT_CLICK_AIR) || action.equals(Action.LEFT_CLICK_BLOCK)) {
            PlayerLeftClickEvent playerLeftClickEvent = new PlayerLeftClickEvent((Player) e.getPlayer(), e.getClickedBlock());
            Bukkit.getServer().getPluginManager().callEvent(playerLeftClickEvent);
            if (playerLeftClickEvent.isCancelled()) {
                e.setCancelled(true);
            }
        }
    }
}
