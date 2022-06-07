package com.ssomar.sevents;

import org.bukkit.event.Listener;

import java.util.EventListener;
import java.util.List;

public abstract class SEvent {

    private EventName eventName;

    public SEvent(EventName eventName){
        this.eventName = eventName;
    }

    public abstract List<Listener> getChildListener();

}
