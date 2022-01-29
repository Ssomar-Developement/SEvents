package com.ssomar.sevents.events.player.click;

import org.bukkit.entity.Entity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.jetbrains.annotations.NotNull;

/** Event creates to call it to damage something and avoid to have a loop of PlayerLeftClickOnEntity / Player **/
public class EntityDamageByEntityEventExtension extends EntityDamageByEntityEvent {

    private boolean isAvoidLoop = false;

    public EntityDamageByEntityEventExtension(@NotNull Entity damager, @NotNull Entity damagee, @NotNull EntityDamageEvent.DamageCause cause, double damage, boolean isAvoidLoop) {
        super(damager, damagee, cause, damage);
        this.isAvoidLoop = isAvoidLoop;
    }

    public boolean isAvoidLoop() {
        return isAvoidLoop;
    }
}
