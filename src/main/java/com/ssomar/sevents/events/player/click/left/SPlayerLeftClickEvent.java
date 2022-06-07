package com.ssomar.sevents.events.player.click.left;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import com.ssomar.sevents.events.player.beforedeath.PlayerBeforeDeathListener;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SPlayerLeftClickEvent extends SEvent {

    public SPlayerLeftClickEvent() {
        super(EventName.PLAYER_LEFT_CLICK_EVENT);
    }

    @Override
    public List<Listener> getChildListener() {
        return new ArrayList<>(Arrays.asList(new PlayerLeftClickListener()));
    }
}
