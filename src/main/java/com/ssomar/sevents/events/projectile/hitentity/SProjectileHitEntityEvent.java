package com.ssomar.sevents.events.projectile.hitentity;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import com.ssomar.sevents.events.player.press.PlayerPressPlateListener;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SProjectileHitEntityEvent extends SEvent {

    public SProjectileHitEntityEvent() {
        super(EventName.PROJECTILE_HIT_ENTITY);
    }

    @Override
    public List<Listener> getChildListener() {
        return new ArrayList<>(Arrays.asList(new ProjectileHitEntityListener()));
    }
}
