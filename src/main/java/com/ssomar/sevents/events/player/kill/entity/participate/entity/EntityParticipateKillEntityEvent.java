package com.ssomar.sevents.events.player.kill.entity.participate.entity;

import org.bukkit.entity.Entity;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityEvent;
import org.jetbrains.annotations.NotNull;

public class EntityParticipateKillEntityEvent extends EntityEvent {

    private static final HandlerList handlers = new HandlerList();
    private final Entity target;


    /**
     * @param target The block clicked, can be null
     */
    public EntityParticipateKillEntityEvent(final Entity entity, final @NotNull Entity target) {
        super(entity);
        this.target = target;
    }

    public Entity getTarget() {
        return target;
    }

    /**
     * Gets a list of handlers handling this event.
     *
     * @return A list of handlers handling this event.
     */
    public static HandlerList getHandlerList() {
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
