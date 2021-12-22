package com.ssomar.sevents.events.player.fish.nothing;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import org.bukkit.event.Listener;

public class SPlayerFishNothingEvent extends SEvent {

    public SPlayerFishNothingEvent() {
        super(EventName.PLAYER_FISH_NOTHING_EVENT);
    }

    @Override
    public Listener getChildListener() {
        return new PlayerFishBlobListener();
    }
}
