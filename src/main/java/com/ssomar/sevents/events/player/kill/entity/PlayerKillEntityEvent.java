package com.ssomar.sevents.events.player.kill.entity;

import org.bukkit.damage.DamageType;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.hanging.HangingBreakEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.vehicle.VehicleDestroyEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PlayerKillEntityEvent extends PlayerEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancel;
    private final Entity entity;
    private int droppedExp;
    private List<ItemStack> drops;
    private String cause;

    /**
     * @param player The player who killed the entity
     * @param entity The entity killed
     * @param droppedExp amount of xp dropped from the killed entity
     * @param drops array of list of drops from the killed entity
     * @param cause possible values: {@link DamageType} enum values, {@link HangingBreakEvent.RemoveCause} enum values and {@code VEHICLE_DESTROY} from {@link PlayerKillEntityListener#onVehicleDestroyEvent(VehicleDestroyEvent)}
     */
    public PlayerKillEntityEvent(final Player player, final @NotNull Entity entity, int droppedExp, List<ItemStack> drops, String cause){
        super(player);
        this.entity = entity;
        this.droppedExp = droppedExp;
        this.drops = drops;
        this.cancel = false;
        this.cause = cause;
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

    public String getCause() {return this.cause;}

    public void setDroppedExp(int droppedExp) {
        this.droppedExp = droppedExp;
    }

    public void setDrops(List<ItemStack> drops) {
        this.drops = drops;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean b) {
        cancel = b;
    }
}
