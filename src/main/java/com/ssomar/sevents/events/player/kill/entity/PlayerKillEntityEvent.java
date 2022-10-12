package com.ssomar.sevents.events.player.kill.entity;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PlayerKillEntityEvent extends PlayerEvent {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;
    private final Entity entity;
    private int droppedExp;
    private List<ItemStack> drops;

    /**
     * @param player The player who put on / removed the armor.
     * @param entity The block clicked, can be null
     */
    public PlayerKillEntityEvent(final Player player, final @NotNull Entity entity, int droppedExp, List<ItemStack> drops){
        super(player);
        this.entity = entity;
        this.droppedExp = droppedExp;
        this.drops = drops;
    }

    public Entity getEntity() {
        return entity;
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
