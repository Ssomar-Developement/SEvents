package com.ssomar.sevents.events.player.fly.active;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import org.bukkit.event.Listener;

public class SPlayerActiveFlyEvent extends SEvent {

    public SPlayerActiveFlyEvent() {
        super(EventName.PLAYER_ACTIVE_FLY_EVENT);
    }

    @Override
    public Listener getChildListener() {
        return new PlayerActiveFlyListener();
    }
}
