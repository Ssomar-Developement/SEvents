package com.ssomar.sevents.events.projectile.hitblock;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityEvent;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ProjectileHitBlockEvent extends EntityEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;
    private final Block block;
    private final BlockFace blockFace;

    /**
     * @param entity The projectile.
     * @param block The block clicked, can be null
     */
    public ProjectileHitBlockEvent(final Entity entity, final @NotNull  Block block, final @NotNull  BlockFace blockFace){
        super(entity);
        this.block = block;
        this.blockFace = blockFace;
    }

    public Block getBlock() {
        return block;
    }

    public BlockFace getBlockFace() {
        return blockFace;
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
