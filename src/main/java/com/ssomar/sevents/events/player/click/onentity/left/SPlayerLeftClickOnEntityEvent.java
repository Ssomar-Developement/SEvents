package com.ssomar.sevents.events.player.click.onentity.left;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import org.bukkit.event.Listener;

public class SPlayerLeftClickOnEntityEvent extends SEvent {

    public SPlayerLeftClickOnEntityEvent() {
        super(EventName.PLAYER_LEFT_CLICK_ON_ENTITY_EVENT);
    }

    @Override
    public Listener getChildListener() {
        return new PlayerLeftClickOnEntityListener();
    }
}
