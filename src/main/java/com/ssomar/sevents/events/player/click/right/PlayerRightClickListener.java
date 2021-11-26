package com.ssomar.sevents.events.player.click.right;

import com.ssomar.sevents.version.Version;
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

import java.util.ArrayList;
import java.util.List;

public class PlayerRightClickListener implements Listener {

    private final List<Material> throwable;

    public PlayerRightClickListener(){
        throwable = new ArrayList<>();

        throwable.add(Material.SPLASH_POTION);
        if(Version._1_12.is()) throwable.add(Material.valueOf("EXP_BOTTLE"));
        else throwable.add(Material.EXPERIENCE_BOTTLE);

        throwable.add(Material.SNOWBALL);
        throwable.add(Material.ENDER_PEARL);
        throwable.add(Material.ENDER_EYE);
    }

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

        // condition to cancel the left click when player right click in the air
        if(action.equals(Action.RIGHT_CLICK_AIR) && throwable.contains(e.getItem().getType())) {
            e.setCancelled(true);
        }

    }
}
