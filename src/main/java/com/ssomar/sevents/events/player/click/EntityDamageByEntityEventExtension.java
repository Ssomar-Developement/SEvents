package com.ssomar.sevents.events.player.click;

import com.google.common.base.Function;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

/** Event creates to call it to damage something and avoid to have a loop of PlayerLeftClickOnEntity / Player **/
public class EntityDamageByEntityEventExtension extends EntityDamageByEntityEvent {

    private boolean isAvoidLoop = false;

    public EntityDamageByEntityEventExtension(@NotNull Entity damager, @NotNull Entity damagee, @NotNull EntityDamageEvent.DamageCause cause, @NotNull Map<DamageModifier, Double> modifiers, @NotNull Map<DamageModifier, ? extends Function<? super Double, Double>> modifierFunctions) {
        super(damager, damagee, cause, modifiers, modifierFunctions);
    }


    public boolean isAvoidLoop() {
        return isAvoidLoop;
    }
}
