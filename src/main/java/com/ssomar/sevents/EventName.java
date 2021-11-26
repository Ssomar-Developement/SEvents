package com.ssomar.sevents;

public enum EventName {
    PLAYER_LEFT_CLICK_EVENT("PlayerLeftClickEvent"),
    PLAYER_RIGHT_CLICK_EVENT("PlayerRightClickEvent"),
    PLAYER_BEFORE_DEATH_EVENT("PlayerBeforeDeathEvent"),
    /*PLAYER_DEATH_EVENT,
    PLAYER_DROP_ITEM_EVENT,
    PLAYER_DROP_THE_EI_EVENT,*/
    PLAYER_LEFT_CLICK_ON_PLAYER_EVENT("PlayerLeftClickOnPlayerEvent"),
    PLAYER_LEFT_CLICK_ON_ENTITY_EVENT("PlayerLeftClickOnEntityEvent"),
    PLAYER_RIGHT_CLICK_ON_PLAYER_EVENT("PlayerRightClickOnPlayerEvent"),
    PLAYER_RIGHT_CLICK_ON_ENTITY_EVENT("PlayerLeftClickOnPlayerEvent"),
    PLAYER_RECEIVE_HIT_BY_PLAYER_EVENT("PlayerReceiveHitByPlayerEvent"),
    PLAYER_RECEIVE_HIT_BY_ENTITY_EVENT("PlayerReceiveHitByEntityEvent"),
    PLAYER_RECEIVE_HIT_GLOBAL_EVENT("PlayerReceiveHitGlobalEvent"),
    PLAYER_KILL_ENTITY_EVENT("PlayerKillEntityEvent"),
    PLAYER_KILL_PLAYER_EVENT("PlayerKillPlayerEvent"),
    PLAYER_FISH_BLOCK_EVENT("PlayerFishBlockEvent"),
    PLAYER_FISH_FISH_EVENT("PlayerFishFishEvent"),
    PLAYER_FISH_ENTITY_EVENT("PlayerFishEntityEvent"),
    PLAYER_FISH_PLAYER_EVENT("PlayerFishPlayerEvent"),
    PLAYER_JUMP_EVENT("PlayerJumpEvent"),
    PLAYER_EQUIP_ARMOR_EVENT("PlayerEquipArmorEvent"),
    PLAYER_ACTIVE_FLY_EVENT("PlayerActiveFlyEvent"),
    PLAYER_DESACTIVE_FLY_EVENT("PlayerDesactiveFlyEvent"),
    PLAYER_ACTIVE_SNEAK_EVENT("PlayerActiveSneakEvent"),
    PLAYER_DESACTIVE_SNEAK_EVENT("PlayerDesactiveSneakEvent"),
    PLAYER_ACTIVE_SPRINT_EVENT("PlayerActiveSprintEvent"),
    PLAYER_DESACTIVE_SPRINT_EVENT("PlayerDesactiveSprintEvent");

    public String name;

    EventName(String name){
        this.name = name;
    }
}
