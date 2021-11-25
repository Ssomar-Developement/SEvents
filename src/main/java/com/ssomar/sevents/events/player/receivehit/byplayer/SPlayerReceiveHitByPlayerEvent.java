package com.ssomar.sevents.events.player.receivehit.byplayer;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import org.bukkit.event.Listener;

public class SPlayerReceiveHitByPlayerEvent extends SEvent {

    public SPlayerReceiveHitByPlayerEvent() {
        super(EventName.PLAYER_RECEIVE_HIT_BY_PLAYER_EVENT);
    }

    @Override
    public Listener getChildListener() {
        return new PlayerReceiveHitByPlayerListener();
    }
}
