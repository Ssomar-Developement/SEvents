package com.ssomar.sevents.events.player.fish.fish;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import com.ssomar.sevents.events.player.click.left.PlayerLeftClickListener;
import org.bukkit.event.Listener;

public class SPlayerFishFishEvent extends SEvent {

    public SPlayerFishFishEvent() {
        super(EventName.PLAYER_FISH_FISH_EVENT);
    }

    @Override
    public Listener getChildListener() {
        return new PlayerFishFishListener();
    }
}
