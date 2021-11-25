package com.ssomar.sevents.events.player.receivehit.byentity;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import org.bukkit.event.Listener;

public class SPlayerReceiveHitByEntityEvent extends SEvent {

    public SPlayerReceiveHitByEntityEvent() {
        super(EventName.PLAYER_RECEIVE_HIT_BY_ENTITY_EVENT);
    }

    @Override
    public Listener getChildListener() {
        return new PlayerReceiveHitByEntityListener();
    }
}
