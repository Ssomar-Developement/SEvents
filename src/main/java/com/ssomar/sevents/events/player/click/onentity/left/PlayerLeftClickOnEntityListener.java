package com.ssomar.sevents.events.player.click.onentity.left;

import com.ssomar.sevents.events.player.click.EntityDamageByEntityEventExtension;
import org.bukkit.Bukkit;
import org.bukkit.EntityEffect;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PlayerLeftClickOnEntityListener implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent e) {

        if (checkExtensionEvent(e)) return;
        if (e.getDamager() instanceof Player) {
            if (!(e.getEntity() instanceof Player)) {
                PlayerLeftClickOnEntityEvent playerLeftClickOnEntityEvent = new PlayerLeftClickOnEntityEvent((Player) e.getDamager(), e.getEntity());
                Bukkit.getServer().getPluginManager().callEvent(playerLeftClickOnEntityEvent);
                if (playerLeftClickOnEntityEvent.isCancelled()) {
                    e.setCancelled(true);
                }
            }
        }

    }

    public static boolean checkExtensionEvent(EntityDamageByEntityEvent e) {
        if (e instanceof EntityDamageByEntityEventExtension && ((EntityDamageByEntityEventExtension) e).isAvoidLoop()) {
            if(e.getEntity() instanceof LivingEntity) {
                LivingEntity ent = (LivingEntity) e.getEntity();
                ent.setLastDamage(e.getDamage());
                ent.setLastDamageCause(e);
                ent.playEffect(EntityEffect.HURT);
                ent.setHealth(ent.getHealth()-e.getFinalDamage());
            }
            return true;
        }
        return false;
    }
}
