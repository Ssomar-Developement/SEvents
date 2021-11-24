package com.ssomar.sevents.events.player.sprint.active;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import org.bukkit.event.Listener;

public class SPlayerActiveSprintEvent extends SEvent {

    public SPlayerActiveSprintEvent() {
        super(EventName.PLAYER_ACTIVE_SPRINT_EVENT);
    }

    @Override
    public Listener getChildListener() {
        return new PlayerActiveSprintListener();
    }
}
