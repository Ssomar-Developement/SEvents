package com.ssomar.sevents.events.player.equip.armor;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Container;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockDispenseArmorEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.*;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Arnah
 * @since Jul 30, 2015
 */
public class PlayerEquipArmorListenerAbove112 implements Listener {

    /** Event not in 1.12 and less **/
    @EventHandler
    public void dispenseArmorEvent(BlockDispenseArmorEvent event){
        ArmorType type = ArmorType.matchType(event.getItem(), false);
        if(type != null){
            if(event.getTargetEntity() instanceof Player){
                PlayerEquipArmorEvent armorEquipEvent = new PlayerEquipArmorEvent((Player)event.getTargetEntity(), PlayerEquipArmorEvent.EquipMethod.DISPENSER, type, null, event.getItem());
                Bukkit.getServer().getPluginManager().callEvent(armorEquipEvent);
                if(armorEquipEvent.isCancelled()){
                    event.setCancelled(true);
                }
            }
        }
    }
}
