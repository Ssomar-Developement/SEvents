package com.ssomar.sevents.events.player.fish.block;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import com.ssomar.sevents.events.player.click.right.PlayerRightClickListener;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SPlayerFishBlockEvent extends SEvent {

    public SPlayerFishBlockEvent() {
        super(EventName.PLAYER_FISH_BLOCK_EVENT);
    }

    @Override
    public List<Listener> getChildListener() {
        return new ArrayList<>(Arrays.asList(new PlayerFishBlockListener()));
    }
}
