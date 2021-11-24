package com.ssomar.sevents.events.player.sprint.desactive;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import org.bukkit.event.Listener;

public class SPlayerDesactiveSprintEvent extends SEvent {

    public SPlayerDesactiveSprintEvent() {
        super(EventName.PLAYER_DESACTIVE_SPRINT_EVENT);
    }

    @Override
    public Listener getChildListener() {
        return new PlayerDesactiveSprintListener();
    }
}
