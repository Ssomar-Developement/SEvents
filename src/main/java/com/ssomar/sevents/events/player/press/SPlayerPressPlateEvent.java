package com.ssomar.sevents.events.player.press;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import org.bukkit.event.Listener;

public class SPlayerPressPlateEvent extends SEvent {

    public SPlayerPressPlateEvent() {
        super(EventName.PLAYER_PRESS_PLATE_EVENT);
    }

    @Override
    public Listener getChildListener() {
        return new PlayerPressPlateListener();
    }
}
