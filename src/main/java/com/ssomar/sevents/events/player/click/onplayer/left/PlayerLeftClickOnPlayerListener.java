package com.ssomar.sevents.events.player.click.onplayer.left;

import com.ssomar.sevents.events.player.click.onentity.left.PlayerLeftClickOnEntityEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PlayerLeftClickOnPlayerListener implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent e) {

        //ignore fake events / required to ignore retard event from MythicLib io/lumine/mythic/lib/listener/SkillTriggers.java
        if(e.getDamage() == 0) return;

        if (e.getDamager() instanceof Player) {

            Player damager = (Player) e.getDamager();
            if (damager.hasMetadata("damageFromCustomCommand"))
                return;

            if (e.getEntity() instanceof Player) {

                /* NPC is not a player O_o */
                if (e.getEntity().hasMetadata("NPC")){
                    PlayerLeftClickOnEntityEvent playerLeftClickOnEntityEvent = new PlayerLeftClickOnEntityEvent((Player) e.getDamager(), e.getEntity());
                    Bukkit.getServer().getPluginManager().callEvent(playerLeftClickOnEntityEvent);
                    if (playerLeftClickOnEntityEvent.isCancelled()) {
                        e.setCancelled(true);
                    }
                }
                else {
                    PlayerLeftClickOnPlayerEvent playerLeftClickOnPlayerEvent = new PlayerLeftClickOnPlayerEvent(damager, (Player) e.getEntity());
                    Bukkit.getServer().getPluginManager().callEvent(playerLeftClickOnPlayerEvent);
                    if (playerLeftClickOnPlayerEvent.isCancelled()) {
                        e.setCancelled(true);
                    }
                }
            }
        }

    }
}
