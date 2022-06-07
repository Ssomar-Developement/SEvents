package com.ssomar.sevents.events.player.receivehit.byentity;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import com.ssomar.sevents.events.player.press.PlayerPressPlateListener;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SPlayerReceiveHitByEntityEvent extends SEvent {

    public SPlayerReceiveHitByEntityEvent() {
        super(EventName.PLAYER_RECEIVE_HIT_BY_ENTITY_EVENT);
    }

    @Override
    public List<Listener> getChildListener() {
        return new ArrayList<>(Arrays.asList(new PlayerReceiveHitByEntityListener()));
    }
}
