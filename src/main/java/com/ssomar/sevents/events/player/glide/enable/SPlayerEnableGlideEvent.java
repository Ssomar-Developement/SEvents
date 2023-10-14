package com.ssomar.sevents.events.player.glide.enable;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SPlayerEnableGlideEvent extends SEvent {

    public SPlayerEnableGlideEvent() {
        super(EventName.PLAYER_ENABLE_GLIDE_EVENT);
    }

    @Override
    public List<Listener> getChildListener() {
        return new ArrayList<>(Arrays.asList(new PlayerEnableGlideListener()));
    }
}
