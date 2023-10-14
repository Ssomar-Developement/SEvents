package com.ssomar.sevents.events.player.glide.disable;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SPlayerDisableGlideEvent extends SEvent {

    public SPlayerDisableGlideEvent() {
        super(EventName.PLAYER_DISABLE_GLIDE_EVENT);
    }

    @Override
    public List<Listener> getChildListener() {
        return new ArrayList<>(Arrays.asList(new PlayerDisableGlideListener()));
    }
}
