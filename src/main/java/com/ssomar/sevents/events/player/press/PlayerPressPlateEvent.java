package com.ssomar.sevents.events.player.press;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerPressPlateEvent extends PlayerEvent {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;
    private final Block block;

    /**
     * @param player The player who put on / removed the armor.
     */
    public PlayerPressPlateEvent(final Player player, final Block block){
        super(player);
        this.block = block;
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

    @Nullable
    public Block getBlock() {
        return block;
    }

    public boolean hasBlock() {return block != null;}
}
