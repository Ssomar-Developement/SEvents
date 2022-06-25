package com.ssomar.sevents.events.player.receivehit.byplayer;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

public class PlayerReceiveHitByPlayerEvent extends PlayerEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;
    private final Player damager;
    private final EntityDamageEvent.DamageCause damageCause;

    /**
     * @param player The player who put on / removed the armor.
     * @param damager The block clicked, can be null
     */
    public PlayerReceiveHitByPlayerEvent(final Player player, final @NotNull Player damager, final @NotNull EntityDamageEvent.DamageCause damageCause){
        super(player);
        this.damager = damager;
        this.damageCause = damageCause;
    }

    public Player getDamager() {
        return damager;
    }

    public EntityDamageEvent.DamageCause getDamageCause() {
        return damageCause;
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
