package com.ssomar.sevents.events.player.kill.player.participate.entity;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SEntityParticipateKillPlayerEvent extends SEvent {

    public SEntityParticipateKillPlayerEvent() {
        super(EventName.ENTITY_PARTICIPATE_KILL_PLAYER_EVENT);
    }

    @Override
    public List<Listener> getChildListener() {
        return new ArrayList<>(Arrays.asList(new EntityParticipateKillPlayerListener()));
    }
}
