package com.ssomar.sevents.events.player.beforedeath;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import org.bukkit.event.Listener;

public class SPlayerBeforeDeathEvent extends SEvent {

    public SPlayerBeforeDeathEvent() {
        super(EventName.PLAYER_BEFORE_DEATH_EVENT);
    }

    @Override
    public Listener getChildListener() {
        return new PlayerBeforeDeathListener();
    }
}
