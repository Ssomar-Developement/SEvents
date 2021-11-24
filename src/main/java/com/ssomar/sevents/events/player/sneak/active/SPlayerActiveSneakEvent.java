package com.ssomar.sevents.events.player.sneak.active;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import org.bukkit.event.Listener;

public class SPlayerActiveSneakEvent extends SEvent {

    public SPlayerActiveSneakEvent() {
        super(EventName.PLAYER_ACTIVE_SNEAK_EVENT);
    }

    @Override
    public Listener getChildListener() {
        return new PlayerActiveSneakListener();
    }
}
