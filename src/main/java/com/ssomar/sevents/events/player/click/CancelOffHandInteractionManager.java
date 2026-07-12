package com.ssomar.sevents.events.player.click;

public class CancelOffHandInteractionManager extends InteractionMarkerManager {

    private static CancelOffHandInteractionManager instance;

    public static CancelOffHandInteractionManager getInstance(){
        if(instance == null) instance = new CancelOffHandInteractionManager();
        return instance;
    }
}
