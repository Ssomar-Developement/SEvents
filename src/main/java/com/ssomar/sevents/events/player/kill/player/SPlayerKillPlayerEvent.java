package com.ssomar.sevents.events.player.kill.player;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import org.bukkit.event.Listener;

public class SPlayerKillPlayerEvent extends SEvent {

    public SPlayerKillPlayerEvent() {
        super(EventName.PLAYER_KILL_PLAYER_EVENT);
    }

    @Override
    public Listener getChildListener() {
        return new PlayerKillPlayerListener();
    }
}
