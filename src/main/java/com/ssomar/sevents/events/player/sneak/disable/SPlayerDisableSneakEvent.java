package com.ssomar.sevents.events.player.sneak.disable;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SPlayerDisableSneakEvent extends SEvent {

    public SPlayerDisableSneakEvent() {
        super(EventName.PLAYER_DISABLE_SNEAK_EVENT);
    }

    @Override
    public List<Listener> getChildListener() {
        return new ArrayList<>(Arrays.asList(new PlayerDisableSneakListener()));
    }
}
