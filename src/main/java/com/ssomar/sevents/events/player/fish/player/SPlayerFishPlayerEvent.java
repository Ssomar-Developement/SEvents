package com.ssomar.sevents.events.player.fish.player;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import com.ssomar.sevents.events.player.click.left.PlayerLeftClickListener;
import org.bukkit.event.Listener;

public class SPlayerFishPlayerEvent extends SEvent {

    public SPlayerFishPlayerEvent() {
        super(EventName.PLAYER_FISH_PLAYER_EVENT);
    }

    @Override
    public Listener getChildListener() {
        return new PlayerFishPlayerListener();
    }
}
