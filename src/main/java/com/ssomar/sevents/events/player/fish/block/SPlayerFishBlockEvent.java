package com.ssomar.sevents.events.player.fish.block;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import org.bukkit.event.Listener;

public class SPlayerFishBlockEvent extends SEvent {

    public SPlayerFishBlockEvent() {
        super(EventName.PLAYER_FISH_BLOCK_EVENT);
    }

    @Override
    public Listener getChildListener() {
        return new PlayerFishBlockListener();
    }
}
