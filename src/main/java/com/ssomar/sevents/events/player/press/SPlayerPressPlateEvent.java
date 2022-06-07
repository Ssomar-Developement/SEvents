package com.ssomar.sevents.events.player.press;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import com.ssomar.sevents.events.player.kill.player.PlayerKillPlayerListener;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SPlayerPressPlateEvent extends SEvent {

    public SPlayerPressPlateEvent() {
        super(EventName.PLAYER_PRESS_PLATE_EVENT);
    }

    @Override
    public List<Listener> getChildListener() {
        return new ArrayList<>(Arrays.asList(new PlayerPressPlateListener()));
    }
}
