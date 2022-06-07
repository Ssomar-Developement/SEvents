package com.ssomar.sevents.events.player.click.onplayer.left;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import com.ssomar.sevents.events.player.click.onentity.right.PlayerRightClickOnEntityListener;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SPlayerLeftClickOnPlayerEvent extends SEvent {

    public SPlayerLeftClickOnPlayerEvent() {
        super(EventName.PLAYER_LEFT_CLICK_ON_PLAYER_EVENT);
    }

    @Override
    public List<Listener> getChildListener() {
        return new ArrayList<>(Arrays.asList(new PlayerLeftClickOnPlayerListener()));
    }
}
