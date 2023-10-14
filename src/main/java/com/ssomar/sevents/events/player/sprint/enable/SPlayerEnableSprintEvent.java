package com.ssomar.sevents.events.player.sprint.enable;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SPlayerEnableSprintEvent extends SEvent {

    public SPlayerEnableSprintEvent() {
        super(EventName.PLAYER_ENABLE_SPRINT_EVENT);
    }

    @Override
    public List<Listener> getChildListener() {
        return new ArrayList<>(Arrays.asList(new PlayerEnableSprintListener()));
    }
}
