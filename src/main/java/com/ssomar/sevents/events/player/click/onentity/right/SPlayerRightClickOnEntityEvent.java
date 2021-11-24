package com.ssomar.sevents.events.player.click.onentity.right;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import org.bukkit.event.Listener;

public class SPlayerRightClickOnEntityEvent extends SEvent {

    public SPlayerRightClickOnEntityEvent() {
        super(EventName.PLAYER_RIGHT_CLICK_ON_ENTITY_EVENT);
    }

    @Override
    public Listener getChildListener() {
        return new PlayerRightClickOnEntityListener();
    }
}
