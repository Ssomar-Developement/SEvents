package com.ssomar.sevents.events.player.brush;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SPlayerBrushBlockEvent extends SEvent {

    public SPlayerBrushBlockEvent() {
        super(EventName.PLAYER_BRUSH_BLOCK_EVENT);
    }

    @Override
    public List<Listener> getChildListener() {
        return new ArrayList<>(Arrays.asList(new PlayerBrushBlockListener()));
    }
}
