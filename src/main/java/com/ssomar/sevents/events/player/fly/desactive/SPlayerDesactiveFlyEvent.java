package com.ssomar.sevents.events.player.fly.desactive;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import org.bukkit.event.Listener;

public class SPlayerDesactiveFlyEvent extends SEvent {

    public SPlayerDesactiveFlyEvent() {
        super(EventName.PLAYER_DESACTIVE_FLY_EVENT);
    }

    @Override
    public Listener getChildListener() {
        return new PlayerDesactiveFlyListener();
    }
}
