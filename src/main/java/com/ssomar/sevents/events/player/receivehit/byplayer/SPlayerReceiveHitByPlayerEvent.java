package com.ssomar.sevents.events.player.receivehit.byplayer;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import com.ssomar.sevents.events.player.press.PlayerPressPlateListener;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SPlayerReceiveHitByPlayerEvent extends SEvent {

    public SPlayerReceiveHitByPlayerEvent() {
        super(EventName.PLAYER_RECEIVE_HIT_BY_PLAYER_EVENT);
    }

    @Override
    public List<Listener>  getChildListener() {
        return new ArrayList<>(Arrays.asList(new PlayerReceiveHitByPlayerListener()));
    }
}
