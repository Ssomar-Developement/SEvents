package com.ssomar.sevents.events.player.click.right;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import org.bukkit.event.Listener;

public class SPlayerRightClickEvent extends SEvent {

    public SPlayerRightClickEvent() {
        super(EventName.PLAYER_RIGHT_CLICK_EVENT);
    }

    @Override
    public Listener getChildListener() {
        return new PlayerRightClickListener();
    }
}
