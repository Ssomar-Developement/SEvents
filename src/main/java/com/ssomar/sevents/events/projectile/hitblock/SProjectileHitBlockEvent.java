package com.ssomar.sevents.events.projectile.hitblock;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import org.bukkit.event.Listener;

public class SProjectileHitBlockEvent extends SEvent {

    public SProjectileHitBlockEvent() {
        super(EventName.PROJECTILE_HIT_BLOCK);
    }

    @Override
    public Listener getChildListener() {
        return new ProjectileHitBlockListener();
    }
}
