package com.ssomar.sevents.events.projectile.hitplayer;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import com.ssomar.sevents.events.player.press.PlayerPressPlateListener;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SProjectileHitPlayerEvent extends SEvent {

    public SProjectileHitPlayerEvent() {
        super(EventName.PROJECTILE_HIT_PLAYER);
    }

    @Override
    public List<Listener> getChildListener() {
        return new ArrayList<>(Arrays.asList(new ProjectileHitPlayerListener()));
    }
}
