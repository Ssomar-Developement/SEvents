package com.ssomar.sevents.events.player.click.onentity.right;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import com.ssomar.sevents.events.player.click.onentity.left.PlayerLeftClickOnEntityListener;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SPlayerRightClickOnEntityEvent extends SEvent {

    public SPlayerRightClickOnEntityEvent() {
        super(EventName.PLAYER_RIGHT_CLICK_ON_ENTITY_EVENT);
    }

    @Override
    public List<Listener> getChildListener() {
        return new ArrayList<>(Arrays.asList(new PlayerRightClickOnEntityListener()));
    }
}
