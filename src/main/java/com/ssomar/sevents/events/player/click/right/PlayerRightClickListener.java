package com.ssomar.sevents.events.player.click.right;

import com.ssomar.sevents.events.player.click.TooManyInteractionManager;
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

    private final List<Material> invoke2LeftClick;
    private final List<Material> invoke3LeftClick;

    public PlayerRightClickListener(){
        invoke2LeftClick = new ArrayList<>();
        invoke3LeftClick = new ArrayList<>();

        invoke2LeftClick.add(Material.WRITTEN_BOOK);
        if(Version.is1v12Less()){
            invoke2LeftClick.add(Material.valueOf("EXP_BOTTLE"));
            invoke2LeftClick.add(Material.valueOf("SNOW_BALL"));
            invoke2LeftClick.add(Material.valueOf("EYE_OF_ENDER"));
        }
        else{
            invoke2LeftClick.add(Material.EXPERIENCE_BOTTLE);
            invoke2LeftClick.add(Material.SNOWBALL);
            invoke2LeftClick.add(Material.FISHING_ROD);
            invoke3LeftClick.add(Material.ENDER_EYE);
        }
        invoke2LeftClick.add(Material.ENDER_PEARL);

        if(!Version.is1v11Less()){
            invoke2LeftClick.add(Material.SPLASH_POTION);
            invoke2LeftClick.add(Material.KNOWLEDGE_BOOK);
        }
    }

    /* I need to be in MONITOR here because CrazyCrates has is one with HIGHTEST , and I need that my event check if the event of CrazyCrates is cancelled or not */
    @EventHandler(priority = EventPriority.MONITOR)
    public void playerInteractEvent(PlayerInteractEvent e) {

        Player p = e.getPlayer();

        Action action = e.getAction();
        if(action.equals(Action.PHYSICAL)) return;

        if(!Version.is1v11Less()) {
            EquipmentSlot equipSlot = e.getHand();
            if (equipSlot == null || (equipSlot.equals(EquipmentSlot.OFF_HAND))) {
                /* important pour que le right clik en off hand soit compté*/
                if (!(p.getInventory().getItemInMainHand().getType().equals(Material.AIR) && action.toString().contains("AIR"))) {

                    /* Temporary fix, cancel usage of spawn eggs in the offhand
                     * for EI create an activator with detailedSlot off hand and put /summon in commands
                     * */
                    if (p.getInventory().getItemInOffHand().getType().toString().contains("SPAWN_EGG")) {
                        e.setCancelled(true);
                    }
                    return;
                }
            }
        }

        if(!(action.equals(Action.LEFT_CLICK_AIR) || action.equals(Action.LEFT_CLICK_BLOCK))) {
            PlayerRightClickEvent playerRightClickEvent = new PlayerRightClickEvent((Player) e.getPlayer(), e.getClickedBlock(), e.getBlockFace(), e.isCancelled());
            Bukkit.getServer().getPluginManager().callEvent(playerRightClickEvent);
            if (playerRightClickEvent.isCancelled()) {
                e.setCancelled(true);
            }
        }

        /* Some items invoke LEFT CLICK after being RIGHT_CLICKED so we need to cancel these LEFT_CLICK*/
        if(action.equals(Action.RIGHT_CLICK_AIR)) {
            if(invoke2LeftClick.contains(e.getItem().getType())){
                TooManyInteractionManager.getInstance().put(p.getUniqueId(), 2);
            }
            else if(invoke3LeftClick.contains(e.getItem().getType())){
                TooManyInteractionManager.getInstance().put(p.getUniqueId(), 3);
            }
        }

    }
}
