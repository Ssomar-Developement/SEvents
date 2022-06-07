package com.ssomar.sevents.events.player.receivehit.global;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import com.ssomar.sevents.events.player.press.PlayerPressPlateListener;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SPlayerReceiveHitGlobalEvent extends SEvent {

    public SPlayerReceiveHitGlobalEvent() {
        super(EventName.PLAYER_RECEIVE_HIT_GLOBAL_EVENT);
    }

    @Override
    public List<Listener> getChildListener() {
        return new ArrayList<>(Arrays.asList(new PlayerReceiveHitGlobalListener()));
    }
}
