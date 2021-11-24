package com.ssomar.sevents.events.player.kill.entity;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import org.bukkit.event.Listener;

public class SPlayerKillEntityEvent extends SEvent {

    public SPlayerKillEntityEvent() {
        super(EventName.PLAYER_KILL_ENTITY_EVENT);
    }

    @Override
    public Listener getChildListener() {
        return new PlayerKillEntityListener();
    }
}
