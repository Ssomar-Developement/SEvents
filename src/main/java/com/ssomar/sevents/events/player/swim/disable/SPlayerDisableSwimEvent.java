package com.ssomar.sevents.events.player.swim.disable;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SPlayerDisableSwimEvent extends SEvent {

    public SPlayerDisableSwimEvent() {
        super(EventName.PLAYER_DISABLE_SWIM_EVENT);
    }

    @Override
    public List<Listener> getChildListener() {
        return new ArrayList<>(Arrays.asList(new PlayerDisableSwimListener()));
    }
}
