package com.ssomar.sevents.events.player.beforedeath.entity;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SEntityBeforeDeathEvent extends SEvent {

    public SEntityBeforeDeathEvent() {
        super(EventName.ENTITY_BEFORE_DEATH_EVENT);
    }

    @Override
    public List<Listener> getChildListener() {
        return new ArrayList<>(Arrays.asList(new EntityBeforeDeathListener()));
    }
}
