package com.ssomar.sevents.events.player.jump;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import com.ssomar.sevents.version.Version;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SPlayerJumpEvent extends SEvent {

    public SPlayerJumpEvent() {
        super(EventName.PLAYER_JUMP_EVENT);
    }

    @Override
    public List<Listener> getChildListener() {
        if(Version.is1v21v3Plus()) return new ArrayList<>(Arrays.asList(new PlayerJumpListener1v21v3()));
        else return new ArrayList<>(Arrays.asList(new PlayerJumpListener()));
    }
}
