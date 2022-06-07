package com.ssomar.sevents.events.player.kill.player;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import com.ssomar.sevents.events.player.kill.entity.PlayerKillEntityListener;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SPlayerKillPlayerEvent extends SEvent {

    public SPlayerKillPlayerEvent() {
        super(EventName.PLAYER_KILL_PLAYER_EVENT);
    }

    @Override
    public List<Listener> getChildListener() {
        return new ArrayList<>(Arrays.asList(new PlayerKillPlayerListener()));
    }
}
