package com.ssomar.sevents.events.player.fish.fish;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import com.ssomar.sevents.events.player.click.left.PlayerLeftClickListener;
import com.ssomar.sevents.events.player.fish.entity.PlayerFishEntityListener;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SPlayerFishFishEvent extends SEvent {

    public SPlayerFishFishEvent() {
        super(EventName.PLAYER_FISH_FISH_EVENT);
    }

    @Override
    public List<Listener> getChildListener() {
        return new ArrayList<>(Arrays.asList(new PlayerFishFishListener()));
    }
}
