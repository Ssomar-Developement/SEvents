package com.ssomar.sevents.events.player.click.onplayer.right;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import org.bukkit.event.Listener;

public class SPlayerRightClickOnPlayerEvent extends SEvent {

    public SPlayerRightClickOnPlayerEvent() {
        super(EventName.PLAYER_RIGHT_CLICK_ON_PLAYER_EVENT);
    }

    @Override
    public Listener getChildListener() {
        return new PlayerRightClickOnPlayerListener();
    }
}
