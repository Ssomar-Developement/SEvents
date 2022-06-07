package com.ssomar.sevents.events.player.sneak.desactive;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import com.ssomar.sevents.events.player.press.PlayerPressPlateListener;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SPlayerDesactiveSneakEvent extends SEvent {

    public SPlayerDesactiveSneakEvent() {
        super(EventName.PLAYER_DESACTIVE_SNEAK_EVENT);
    }

    @Override
    public List<Listener> getChildListener() {
        return new ArrayList<>(Arrays.asList(new PlayerDesactiveSneakListener()));
    }
}
