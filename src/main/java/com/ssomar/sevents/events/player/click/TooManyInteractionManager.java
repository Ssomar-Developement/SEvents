package com.ssomar.sevents.events.player.click;

public class TooManyInteractionManager extends InteractionMarkerManager {

    private static TooManyInteractionManager instance;

    public static TooManyInteractionManager getInstance(){
        if(instance == null) instance = new TooManyInteractionManager();
        return instance;
    }
}
