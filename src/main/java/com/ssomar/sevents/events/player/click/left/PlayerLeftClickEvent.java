package com.ssomar.sevents.events.player.click.left;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerLeftClickEvent extends PlayerEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;
    private final Block block;

    /**
     * @param player The player who put on / removed the armor.
     * @param block The block clicked, can be null
     */
    public PlayerLeftClickEvent(final Player player, final @Nullable  Block block){
        super(player);
        this.block = block;
    }

    public boolean hasBlock() {return block != null;}

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