package com.ssomar.sevents.events.player.jump;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import org.bukkit.event.Listener;

public class SPlayerJumpEvent extends SEvent {

    public SPlayerJumpEvent() {
        super(EventName.PLAYER_JUMP_EVENT);
    }

    @Override
    public Listener getChildListener() {
        return new PlayerJumpListener();
    }
}
