package com.ssomar.sevents.events.player.fish.nothing;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import com.ssomar.sevents.events.player.fish.fish.PlayerFishFishListener;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SPlayerFishNothingEvent extends SEvent {

    public SPlayerFishNothingEvent() {
        super(EventName.PLAYER_FISH_NOTHING_EVENT);
    }

    @Override
    public List<Listener> getChildListener() {
        return new ArrayList<>(Arrays.asList(new PlayerFishBlobListener()));
    }
}
