package com.ssomar.sevents.events.player.sprint.desactive;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import com.ssomar.sevents.events.player.press.PlayerPressPlateListener;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SPlayerDesactiveSprintEvent extends SEvent {

    public SPlayerDesactiveSprintEvent() {
        super(EventName.PLAYER_DESACTIVE_SPRINT_EVENT);
    }

    @Override
    public List<Listener> getChildListener() {
        return new ArrayList<>(Arrays.asList(new PlayerDesactiveSprintListener()));
    }
}
