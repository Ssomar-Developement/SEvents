package com.ssomar.sevents.events.projectile.hitenttity;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import org.bukkit.event.Listener;

public class SProjectileHitEntityEvent extends SEvent {

    public SProjectileHitEntityEvent() {
        super(EventName.PROJECTILE_HIT_ENTITY);
    }

    @Override
    public Listener getChildListener() {
        return new ProjectileHitEntityListener();
    }
}
