package com.ssomar.sevents.events.player.sneak.active;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import com.ssomar.sevents.events.player.press.PlayerPressPlateListener;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SPlayerActiveSneakEvent extends SEvent {

    public SPlayerActiveSneakEvent() {
        super(EventName.PLAYER_ACTIVE_SNEAK_EVENT);
    }

    @Override
    public List<Listener> getChildListener() {
        return new ArrayList<>(Arrays.asList(new PlayerActiveSneakListener()));
    }
}
