package com.ssomar.sevents.events.player.click.onplayer.left;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import org.bukkit.event.Listener;

public class SPlayerLeftClickOnPlayerEvent extends SEvent {

    public SPlayerLeftClickOnPlayerEvent() {
        super(EventName.PLAYER_LEFT_CLICK_ON_PLAYER_EVENT);
    }

    @Override
    public Listener getChildListener() {
        return new PlayerLeftClickOnPlayerListener();
    }
}
