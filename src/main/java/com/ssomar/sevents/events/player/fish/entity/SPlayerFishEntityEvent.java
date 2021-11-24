package com.ssomar.sevents.events.player.fish.entity;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import org.bukkit.event.Listener;

public class SPlayerFishEntityEvent extends SEvent {

    public SPlayerFishEntityEvent() {
        super(EventName.PLAYER_FISH_ENTITY_EVENT);
    }

    @Override
    public Listener getChildListener() {
        return new PlayerFishEntityListener();
    }
}
