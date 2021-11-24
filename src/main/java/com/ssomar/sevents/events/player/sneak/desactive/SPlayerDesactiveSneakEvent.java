package com.ssomar.sevents.events.player.sneak.desactive;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import org.bukkit.event.Listener;

public class SPlayerDesactiveSneakEvent extends SEvent {

    public SPlayerDesactiveSneakEvent() {
        super(EventName.PLAYER_DESACTIVE_SNEAK_EVENT);
    }

    @Override
    public Listener getChildListener() {
        return new PlayerDesactiveSneakListener();
    }
}
