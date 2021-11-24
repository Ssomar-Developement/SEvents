package com.ssomar.sevents;

import com.ssomar.sevents.events.player.click.right.SPlayerRightClickEvent;

public class SEventFactory {

    public SEvent getSEvent(EventName eventName){
        switch (eventName){
            case PLAYER_RIGHT_CLICK_EVENT -> {
                return new SPlayerRightClickEvent();
            }
            default -> {
                return null;
            }
        }

    }
}
