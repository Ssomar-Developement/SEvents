package com.ssomar.sevents.events.player.tramplecrop;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import com.ssomar.sevents.events.player.press.PlayerPressPlateListener;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SPlayerTrampleCropEvent extends SEvent {

    public SPlayerTrampleCropEvent() {
        super(EventName.PLAYER_TRAMPLE_CROP_EVENT);
    }

    @Override
    public List<Listener> getChildListener() {
        return new ArrayList<>(Arrays.asList(new PlayerTrampleCropListener()));
    }
}
