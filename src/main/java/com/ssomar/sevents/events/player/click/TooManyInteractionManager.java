package com.ssomar.sevents.events.player.click;

import java.util.HashMap;
import java.util.UUID;

public class TooManyInteractionManager extends HashMap<UUID, Integer> {

    private static TooManyInteractionManager instance;

    public static TooManyInteractionManager getInstance(){
        if(instance == null) instance = new TooManyInteractionManager();
        return instance;
    }
}
