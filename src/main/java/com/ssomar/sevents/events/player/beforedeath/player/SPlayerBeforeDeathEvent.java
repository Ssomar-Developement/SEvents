package com.ssomar.sevents.events.player.beforedeath.player;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SPlayerBeforeDeathEvent extends SEvent {

    public SPlayerBeforeDeathEvent() {
        super(EventName.PLAYER_BEFORE_DEATH_EVENT);
    }

    @Override
    public List<Listener> getChildListener() {
        return new ArrayList<>(Arrays.asList(new PlayerBeforeDeathListener()));
    }
}
