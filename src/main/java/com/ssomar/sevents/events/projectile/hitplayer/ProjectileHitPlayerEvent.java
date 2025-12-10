package com.ssomar.sevents.events.projectile.hitplayer;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.jetbrains.annotations.NotNull;

public class ProjectileHitPlayerEvent extends EntityEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;
    private final Player target;
    private final ProjectileHitEvent projectileHitEvent;

    /**
     * @param entity The projectile.
     * @param target The entity that receives the projectile
     */
    public ProjectileHitPlayerEvent(final Entity entity, final @NotNull Player target, final ProjectileHitEvent projectileHitEvent){
        super(entity);
        this.target = target;
        this.projectileHitEvent = projectileHitEvent;
    }

    public Player getTarget() {
        return target;
    }

    public ProjectileHitEvent getProjectileHitEvent() {return this.projectileHitEvent;}

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
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
}
