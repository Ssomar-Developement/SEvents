package com.ssomar.sevents.events.player.click.right;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerRightClickEvent extends PlayerEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;
    private final Block block;

    /**
     * @param player The player who put on / removed the armor.
     * @param block The block clicked, can be null
     */
    public PlayerRightClickEvent(final Player player, final @Nullable  Block block){
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

    @Override
    public final @NotNull HandlerList getHandlers() {
        return handlers;
    }
}
