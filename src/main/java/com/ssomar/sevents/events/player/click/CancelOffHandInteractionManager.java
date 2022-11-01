package com.ssomar.sevents.events.player.click;

import java.util.HashMap;
import java.util.UUID;

public class CancelOffHandInteractionManager extends HashMap<UUID, Integer> {

    private static CancelOffHandInteractionManager instance;

    public static CancelOffHandInteractionManager getInstance(){
        if(instance == null) instance = new CancelOffHandInteractionManager();
        return instance;
    }
}
