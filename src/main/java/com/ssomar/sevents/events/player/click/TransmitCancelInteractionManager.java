package com.ssomar.sevents.events.player.click;

import java.util.HashMap;
import java.util.UUID;

public class TransmitCancelInteractionManager extends HashMap<UUID, Integer> {

    private static TransmitCancelInteractionManager instance;

    public static TransmitCancelInteractionManager getInstance(){
        if(instance == null) instance = new TransmitCancelInteractionManager();
        return instance;
    }
}
