package com.ssomar.sevents.events.player.receivehit.global;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

public class PlayerReceiveHitGlobalEvent extends PlayerEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;
    private final EntityDamageEvent.DamageCause damageCause;
    private final EntityDamageEvent entityDamageEvent;

    /**
     * @param player The player who put on / removed the armor.
     */
    public PlayerReceiveHitGlobalEvent(final Player player, final EntityDamageEvent entityDamageEvent){
        super(player);
        this.damageCause = entityDamageEvent.getCause();
        this.entityDamageEvent = entityDamageEvent;
    }

    public EntityDamageEvent.DamageCause getDamageCause() {
        return damageCause;
    }

    public EntityDamageEvent getEntityDamageEvent() {
        return this.entityDamageEvent;
    }

    /**
     * Gets a list of handlers handling this event.
     *
     * @return A list of handlers handling this event.
     */
    public static HandlerList getHandlerList(){
        return handlers;
    }

    /**
     * Gets a list of handlers handling this event.
     *
     * @return A list of handlers handling this event.
     */
    @Override
    public final @NotNull HandlerList getHandlers() {
        return handlers;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }
}
