package com.ssomar.sevents.events.player.fly.desactive;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import com.ssomar.sevents.events.player.fly.active.PlayerActiveFlyListener;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SPlayerDesactiveFlyEvent extends SEvent {

    public SPlayerDesactiveFlyEvent() {
        super(EventName.PLAYER_DESACTIVE_FLY_EVENT);
    }

    @Override
    public List<Listener> getChildListener() {
        return new ArrayList<>(Arrays.asList(new PlayerDesactiveFlyListener()));
    }
}
