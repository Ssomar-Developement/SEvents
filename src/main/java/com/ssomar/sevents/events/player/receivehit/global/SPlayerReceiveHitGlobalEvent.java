package com.ssomar.sevents.events.player.receivehit.global;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import org.bukkit.event.Listener;

public class SPlayerReceiveHitGlobalEvent extends SEvent {

    public SPlayerReceiveHitGlobalEvent() {
        super(EventName.PLAYER_RECEIVE_HIT_GLOBAL_EVENT);
    }

    @Override
    public Listener getChildListener() {
        return new PlayerReceiveHitGlobalListener();
    }
}
