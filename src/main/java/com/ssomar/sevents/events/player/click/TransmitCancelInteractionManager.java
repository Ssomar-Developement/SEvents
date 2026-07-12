package com.ssomar.sevents.events.player.click;

public class TransmitCancelInteractionManager extends InteractionMarkerManager {

    private static TransmitCancelInteractionManager instance;

    public static TransmitCancelInteractionManager getInstance(){
        if(instance == null) instance = new TransmitCancelInteractionManager();
        return instance;
    }
}
