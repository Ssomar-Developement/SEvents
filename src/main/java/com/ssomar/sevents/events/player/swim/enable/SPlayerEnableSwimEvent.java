package com.ssomar.sevents.events.player.swim.enable;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SPlayerEnableSwimEvent extends SEvent {

    public SPlayerEnableSwimEvent() {
        super(EventName.PLAYER_ENABLE_SWIM_EVENT);
    }

    @Override
    public List<Listener> getChildListener() {
        return new ArrayList<>(Arrays.asList(new PlayerEnableSwimListener()));
    }
}
