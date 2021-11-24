package com.ssomar.sevents;

import com.ssomar.sevents.events.player.click.left.SPlayerLeftClickEvent;
import com.ssomar.sevents.events.player.click.right.SPlayerRightClickEvent;
import com.ssomar.sevents.events.player.fish.block.SPlayerFishBlockEvent;
import com.ssomar.sevents.events.player.fish.entity.SPlayerFishEntityEvent;
import com.ssomar.sevents.events.player.fish.fish.SPlayerFishFishEvent;
import com.ssomar.sevents.events.player.fish.player.SPlayerFishPlayerEvent;
import com.ssomar.sevents.events.player.sneak.active.SPlayerActiveSneakEvent;
import com.ssomar.sevents.events.player.sneak.desactive.SPlayerDesactiveSneakEvent;
import com.ssomar.sevents.events.player.sprint.active.SPlayerActiveSprintEvent;
import com.ssomar.sevents.events.player.sprint.desactive.SPlayerDesactiveSprintEvent;

public class SEventFactory {

    public SEvent getSEvent(EventName eventName){
        switch (eventName){
            case PLAYER_RIGHT_CLICK_EVENT:
                return new SPlayerRightClickEvent();
            case PLAYER_LEFT_CLICK_EVENT:
                return new SPlayerLeftClickEvent();
                
            case PLAYER_FISH_FISH_EVENT:
                return new SPlayerFishFishEvent();
            case PLAYER_FISH_PLAYER_EVENT:
                return new SPlayerFishPlayerEvent();
            case PLAYER_FISH_ENTITY_EVENT:
                return new SPlayerFishEntityEvent();
            case PLAYER_FISH_BLOCK_EVENT:
                return new SPlayerFishBlockEvent();

            case PLAYER_ACTIVE_SNEAK_EVENT:
                return new SPlayerActiveSneakEvent();
            case PLAYER_DESACTIVE_SNEAK_EVENT:
                return new SPlayerDesactiveSneakEvent();

            case PLAYER_ACTIVE_SPRINT_EVENT:
                return new SPlayerActiveSprintEvent();
            case PLAYER_DESACTIVE_SPRINT_EVENT:
                return new SPlayerDesactiveSprintEvent();
            default:
                return null;
        }

    }
}
