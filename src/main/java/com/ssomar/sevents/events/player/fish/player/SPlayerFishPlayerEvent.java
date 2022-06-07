package com.ssomar.sevents.events.player.fish.player;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import com.ssomar.sevents.events.player.click.left.PlayerLeftClickListener;
import com.ssomar.sevents.events.player.fish.nothing.PlayerFishBlobListener;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SPlayerFishPlayerEvent extends SEvent {

    public SPlayerFishPlayerEvent() {
        super(EventName.PLAYER_FISH_PLAYER_EVENT);
    }

    @Override
    public List<Listener> getChildListener() {
        return new ArrayList<>(Arrays.asList(new PlayerFishPlayerListener()));
    }
}
