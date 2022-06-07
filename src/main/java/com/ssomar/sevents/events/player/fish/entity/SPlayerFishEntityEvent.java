package com.ssomar.sevents.events.player.fish.entity;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import com.ssomar.sevents.events.player.fish.block.PlayerFishBlockListener;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SPlayerFishEntityEvent extends SEvent {

    public SPlayerFishEntityEvent() {
        super(EventName.PLAYER_FISH_ENTITY_EVENT);
    }

    @Override
    public List<Listener> getChildListener() {
        return new ArrayList<>(Arrays.asList(new PlayerFishEntityListener()));
    }
}
