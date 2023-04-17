package com.ssomar.sevents.events.player.kill.entity.participate.player;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

public class PlayerParticipateKillEntityEvent extends PlayerEvent {

    private static final HandlerList handlers = new HandlerList();
    private final Entity target;


    /**
     * @param player The player who put on / removed the armor.
     * @param target The block clicked, can be null
     */
    public PlayerParticipateKillEntityEvent(final Player player, final @NotNull Entity target) {
        super(player);
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
