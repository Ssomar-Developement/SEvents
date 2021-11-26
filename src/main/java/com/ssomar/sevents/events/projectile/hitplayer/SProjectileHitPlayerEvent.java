package com.ssomar.sevents.events.projectile.hitplayer;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import org.bukkit.event.Listener;

public class SProjectileHitPlayerEvent extends SEvent {

    public SProjectileHitPlayerEvent() {
        super(EventName.PROJECTILE_HIT_PLAYER);
    }

    @Override
    public Listener getChildListener() {
        return new ProjectileHitPlayerListener();
    }
}
