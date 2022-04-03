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

        boolean cancel = false;
        Player p = e.getPlayer();

        /* Not in this version */
        if (!(Version._1_12.is() || Version._1_13.is() || Version._1_14.is())) {

            Block b = p.getTargetBlock(null, 5);

            Location pLoc = p.getLocation();
            pLoc.add(0, 1, 0);

            double distance = pLoc.distance(b.getLocation());

            if (b.getType() != Material.AIR) {

                if (distance < 5.3 && distance >= 5.0) {

                    float pitch = pLoc.getPitch();
                    float yaw = pLoc.getYaw();

                    if (yaw > 225 && yaw < 315) {
                        if ((267 <= yaw && yaw <= 273) && (-3 <= pitch && pitch <= 3)) {

                        } else {

                            cancel = true;
                        }
                    } else if (yaw > 315 || yaw < 45) {
                        if ((357 >= yaw || yaw <= 3) && (-3 <= pitch && pitch <= 3)) {

                        } else {

                            cancel = true;
                        }
                    } else if (yaw > 45 && yaw < 135) {
                        if ((89 <= yaw && yaw <= 93) && (-3 <= pitch && pitch <= 3)) {

                        } else {

                            cancel = true;
                        }
                    } else if (yaw > 135 && yaw < 225) {
                        if ((177 <= yaw && yaw <= 183) && (-3 <= pitch && pitch <= 3)) {

                        } else {

                            cancel = true;
                        }
                    }

                }
                // else somarDev.testMsg(">>>>>>>>>>>>>>> PAS ICI");
            } else {
                // SsomarDev.testMsg(">>>>>>>>>>>>>>> ON BLOCK ICI");
                cancel = true;
            }
        }


        if (cancel) {
            //System.out.println("ADD CANCEL INTERACT");
            cancelInteraction.add(p.getUniqueId());
        }
    }
}
