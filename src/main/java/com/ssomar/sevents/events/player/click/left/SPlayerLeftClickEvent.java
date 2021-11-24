package com.ssomar.sevents.events.player.click.left;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import org.bukkit.event.Listener;

public class SPlayerLeftClickEvent extends SEvent {

    public SPlayerLeftClickEvent() {
        super(EventName.PLAYER_LEFT_CLICK_EVENT);
    }

    @Override
    public Listener getChildListener() {
        return new PlayerLeftClickListener();
    }
}
