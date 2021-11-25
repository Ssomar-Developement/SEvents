package com.ssomar.sevents.events.player.fertilizeblock;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import org.bukkit.event.Listener;

public class SPlayerFertilizeBlockEvent extends SEvent {

    public SPlayerFertilizeBlockEvent() {
        super(EventName.PLAYER_FERTILIZE_BLOCK_EVENT);
    }

    @Override
    public Listener getChildListener() {
        return new PlayerFertilizeBlockListener();
    }
}
