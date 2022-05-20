package com.ssomar.sevents.events.player.tramplecrops;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import org.bukkit.event.Listener;

public class SPlayerTrampleCropEvent extends SEvent {

    public SPlayerTrampleCropEvent() {
        super(EventName.PLAYER_TRAMPLE_CROP_EVENT);
    }

    @Override
    public Listener getChildListener() {
        return new PlayerTrampleCropListener();
    }
}
