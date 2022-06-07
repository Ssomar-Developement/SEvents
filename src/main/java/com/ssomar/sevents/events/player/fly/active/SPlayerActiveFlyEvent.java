package com.ssomar.sevents.events.player.fly.active;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import com.ssomar.sevents.events.player.fish.player.PlayerFishPlayerListener;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SPlayerActiveFlyEvent extends SEvent {

    public SPlayerActiveFlyEvent() {
        super(EventName.PLAYER_ACTIVE_FLY_EVENT);
    }

    @Override
    public List<Listener> getChildListener() {
        return new ArrayList<>(Arrays.asList(new PlayerActiveFlyListener()));
    }
}
