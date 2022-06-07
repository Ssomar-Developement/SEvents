package com.ssomar.sevents.events.projectile.hitblock;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import com.ssomar.sevents.events.player.press.PlayerPressPlateListener;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SProjectileHitBlockEvent extends SEvent {

    public SProjectileHitBlockEvent() {
        super(EventName.PROJECTILE_HIT_BLOCK);
    }

    @Override
    public List<Listener> getChildListener() {
        return new ArrayList<>(Arrays.asList( new ProjectileHitBlockListener()));
    }
}
