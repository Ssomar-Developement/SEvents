package com.ssomar.sevents.events.player.kill.entity;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import com.ssomar.sevents.events.player.jump.PlayerJumpListener;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SPlayerKillEntityEvent extends SEvent {

    public SPlayerKillEntityEvent() {
        super(EventName.PLAYER_KILL_ENTITY_EVENT);
    }

    @Override
    public List<Listener> getChildListener() {
        return new ArrayList<>(Arrays.asList(new PlayerKillEntityListener()));
    }
}
