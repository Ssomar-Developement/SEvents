package com.ssomar.sevents.events.player.sneak.enable;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SPlayerEnableSneakEvent extends SEvent {

    public SPlayerEnableSneakEvent() {
        super(EventName.PLAYER_ENABLE_SNEAK_EVENT);
    }

    @Override
    public List<Listener> getChildListener() {
        return new ArrayList<>(Arrays.asList(new PlayerEnableSneakListener()));
    }
}
