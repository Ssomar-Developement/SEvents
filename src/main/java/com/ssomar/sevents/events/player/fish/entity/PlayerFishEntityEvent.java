package com.ssomar.sevents.events.player.fish.entity;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

public class PlayerFishEntityEvent extends PlayerEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;
    private final Entity entity;

    /**
     * @param player The player who put on / removed the armor.
     * @param entity The entity that received the hook
     */
    public PlayerFishEntityEvent(final Player player, final @NotNull Entity entity){
        super(player);
        this.entity = entity;
    }

    public Entity getEntity() {
        return entity;
    }

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
