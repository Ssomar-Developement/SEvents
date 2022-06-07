package com.ssomar.sevents.events.player.click.right;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import com.ssomar.sevents.events.player.click.onplayer.right.PlayerRightClickOnPlayerListener;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SPlayerRightClickEvent extends SEvent {

    public SPlayerRightClickEvent() {
        super(EventName.PLAYER_RIGHT_CLICK_EVENT);
    }

    @Override
    public List<Listener> getChildListener() {
        return new ArrayList<>(Arrays.asList(new PlayerRightClickListener()));
    }
}
