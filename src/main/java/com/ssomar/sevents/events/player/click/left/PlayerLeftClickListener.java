package com.ssomar.sevents.events.player.click.left;

import com.ssomar.sevents.events.player.click.TooManyInteractionManager;
import com.ssomar.sevents.version.Version;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class PlayerLeftClickListener implements Listener {

    private final List<UUID> cancelInteraction;

    public PlayerLeftClickListener(){
        cancelInteraction = new ArrayList<>();
    }

    //#TODO WHEN LEFT CLICK TO BREAK A BLOCK AND WHEN THERE IS AIR BEHIND THE BLOCK THE LEFT CLICK IS ACTIVATED TWO TIMES
    @EventHandler(priority = EventPriority.HIGHEST)
    public void playerInteractEvent(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        UUID pUUID = p.getUniqueId();

        //System.out.println("TOO MANY INTERACT CHECK");
        if(TooManyInteractionManager.getInstance().containsKey(pUUID)){

            int amount = TooManyInteractionManager.getInstance().get(pUUID);
            //System.out.println("TOO MANY INTERACT Contains: "+amount);
            if(amount > 0) {
                if(amount == 1) TooManyInteractionManager.getInstance().remove(pUUID);
                else TooManyInteractionManager.getInstance().put(pUUID, amount - 1);
                //System.out.println("TOO MANY interact cancel");
                return;
            }
        }

        // Cancel if its necessary
        //System.out.println("LEFT CLICK INFO: "+e.getAction()+" :: "+e.getHand()+" :: "+e.getMaterial()+" :: "+e.useItemInHand());
        //System.out.println("PREDETECT CANCEL INTERACT");
        if (cancelInteraction.contains(pUUID)) {
            //System.out.println("DETECT CANCEL INTERACT");
            cancelInteraction.removeAll(Collections.singleton(pUUID));
            e.setCancelled(true);
            return;
        }

        Action action = e.getAction();
        if (action.equals(Action.PHYSICAL)) return;

        if (action.equals(Action.LEFT_CLICK_AIR) || action.equals(Action.LEFT_CLICK_BLOCK)) {
            PlayerLeftClickEvent playerLeftClickEvent = new PlayerLeftClickEvent((Player) e.getPlayer(), e.getClickedBlock(), e.getBlockFace());
            Bukkit.getServer().getPluginManager().callEvent(playerLeftClickEvent);
            if (playerLeftClickEvent.isCancelled()) {
                e.setCancelled(true);
            }
        }
    }
    
    /* To block the weird click generates by the drop */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerDropItemEvent(PlayerDropItemEvent e) {

        Player p = e.getPlayer();

        /* Not in this version */
        if (!Version.is1v13Less() || Version.is1v14()) {

            Location eyeLoc = p.getEyeLocation().clone();
            for (double j = 0; j <= 5; j += 0.1) {
                Vector vec = eyeLoc.getDirection();
                Location newLoc = eyeLoc.clone().add(vec.multiply(j));
                Block b2 = newLoc.getBlock();
                if (!b2.isEmpty()) {
                    if (b2.getBoundingBox().contains(newLoc.getX(), newLoc.getY(), newLoc.getZ())) {
                        //SsomarDev.testMsg("Block: " + b2.getType() + " >>" + j);
                        return;
                    }
                }
            }
            cancelInteraction.add(p.getUniqueId());
            return;
        }
    }
}
