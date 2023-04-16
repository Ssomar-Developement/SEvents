package com.ssomar.sevents.events.block;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SBlockDryEvent extends SEvent {

    public SBlockDryEvent() {
        super(EventName.BLOCK_DRY);
    }

    @Override
    public List<Listener> getChildListener() {
        return new ArrayList<>(Arrays.asList(new BlockDryListener()));
    }
}
