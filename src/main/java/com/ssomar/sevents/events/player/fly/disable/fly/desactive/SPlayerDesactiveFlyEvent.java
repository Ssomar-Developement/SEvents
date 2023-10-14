package com.ssomar.sevents.events.player.fly.disable.fly.desactive;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SPlayerDesactiveFlyEvent extends SEvent {

    public SPlayerDesactiveFlyEvent() {
        super(EventName.PLAYER_DISABLE_FLY_EVENT);
    }

    @Override
    public List<Listener> getChildListener() {
        return new ArrayList<>(Arrays.asList(new PlayerDesactiveFlyListener()));
    }
}
