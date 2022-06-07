package com.ssomar.sevents.events.player.click.onplayer.right;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import com.ssomar.sevents.events.player.click.onplayer.left.PlayerLeftClickOnPlayerListener;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SPlayerRightClickOnPlayerEvent extends SEvent {

    public SPlayerRightClickOnPlayerEvent() {
        super(EventName.PLAYER_RIGHT_CLICK_ON_PLAYER_EVENT);
    }

    @Override
    public List<Listener> getChildListener() {
        return new ArrayList<>(Arrays.asList(new PlayerRightClickOnPlayerListener()));
    }
}
