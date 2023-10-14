package com.ssomar.sevents.events.player.fly.enable;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SPlayerEnableFlyEvent extends SEvent {

    public SPlayerEnableFlyEvent() {
        super(EventName.PLAYER_ENABLE_FLY_EVENT);
    }

    @Override
    public List<Listener> getChildListener() {
        return new ArrayList<>(Arrays.asList(new PlayerEnableFlyListener()));
    }
}
