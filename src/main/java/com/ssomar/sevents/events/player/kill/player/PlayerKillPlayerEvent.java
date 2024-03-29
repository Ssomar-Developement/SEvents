package com.ssomar.sevents.events.player.kill.player;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PlayerKillPlayerEvent extends PlayerEvent {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;
    private final Player target;
    private int droppedExp;
    private List<ItemStack> drops;


    /**
     * @param player The player who put on / removed the armor.
     * @param target The block clicked, can be null
     */
    public PlayerKillPlayerEvent(final Player player, final @NotNull Player target, int droppedExp, List<ItemStack> drops){
        super(player);
        this.target = target;
        this.droppedExp = droppedExp;
        this.drops = drops;
    }

    public Player getTarget() {
        return target;
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

    public int getDroppedExp() {
        return droppedExp;
    }

    public List<ItemStack> getDrops() {
        return drops;
    }

    public void setDroppedExp(int droppedExp) {
        this.droppedExp = droppedExp;
    }

    public void setDrops(List<ItemStack> drops) {
        this.drops = drops;
    }
}
