package com.ssomar.sevents.events.player.click.onentity.left;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import com.ssomar.sevents.events.player.click.left.PlayerLeftClickListener;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SPlayerLeftClickOnEntityEvent extends SEvent {

    public SPlayerLeftClickOnEntityEvent() {
        super(EventName.PLAYER_LEFT_CLICK_ON_ENTITY_EVENT);
    }

    @Override
    public List<Listener> getChildListener() {
        return new ArrayList<>(Arrays.asList(new PlayerLeftClickOnEntityListener()));
    }
}
