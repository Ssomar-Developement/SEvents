package com.ssomar.sevents;

public enum EventName {
    //PROJECTILE_LAUNCH_EVENT,
    PLAYER_LEFT_CLICK_EVENT("PlayerLeftClickEvent"),
    PLAYER_RIGHT_CLICK_EVENT("PlayerRightClickEvent"),
    //PLAYER_ITEM_CONSUME_EVENT,
    PLAYER_BEFORE_DEATH_EVENT("PlayerBeforeDeathEvent"),
    /*PLAYER_DEATH_EVENT,
    PLAYER_DROP_ITEM_EVENT,
    PLAYER_DROP_THE_EI_EVENT,*/
    PLAYER_LEFT_CLICK_ON_PLAYER_EVENT("PlayerLeftClickOnPlayerEvent"),
    PLAYER_LEFT_CLICK_ON_ENTITY_EVENT("PlayerLeftClickOnEntityEvent"),
    PLAYER_RIGHT_CLICK_ON_PLAYER_EVENT("PlayerRightClickOnPlayerEvent"),
    PLAYER_RIGHT_CLICK_ON_ENTITY_EVENT("PlayerLeftClickOnPlayerEvent"),
    /*INVENTORY_CLICK_EVENT,
    BLOCK_BREAK_EVENT,
    BLOCK_PLACE_EVENT,
    PLAYER_JOIN_EVENT,*/
    PLAYER_RECEIVE_HIT_BY_PLAYER_EVENT("PlayerReceiveHitByPlayerEvent"),
    PLAYER_RECEIVE_HIT_BY_ENTITY_EVENT("PlayerReceiveHitByEntityEvent"),
    PLAYER_RECEIVE_HIT_GLOBAL_EVENT("PlayerReceiveHitGlobalEvent"),
    PLAYER_KILL_ENTITY_EVENT("PlayerKillEntityEvent"),
    PLAYER_KILL_PLAYER_EVENT("PlayerKillPlayerEvent"),
    PLAYER_FERTILIZE_BLOCK_EVENT("PlayerFertilizeBlockEvent"),
    //PLAYER_BUCKET_FILL_EVENT,
    PLAYER_FISH_BLOCK_EVENT("PlayerFishBlockEvent"),
    PLAYER_FISH_FISH_EVENT("PlayerFishFishEvent"),
    PLAYER_FISH_ENTITY_EVENT("PlayerFishEntityEvent"),
    PLAYER_FISH_PLAYER_EVENT("PlayerFishPlayerEvent"),
    PLAYER_JUMP_EVENT("PlayerJumpEventEvent"),
   /* LOOP_EVENT,
    PLAYER_BED_ENTER_EVENT,
    PLAYER_BED_LEAVE_EVENT,
    PLAYER_CHANGE_WORLD_EVENT,
    PLAYER_EDIT_BOOK_EVENT,
    PLAYER_EQUIP_THE_EI_EVENT,
    PLAYER_ITEM_BREAK_EVENT,
    PLAYER_RESPAWN_EVENT,
    PLAYER_SHEAR_ENTITY_EVENT,
    PLAYER_ACTIVE_FLY_EVENT,*/
    PLAYER_ACTIVE_SNEAK_EVENT("PlayerActiveSneakEvent"),
    PLAYER_DESACTIVE_SNEAK_EVENT("PlayerDesactiveSneakEvent"),
    PLAYER_ACTIVE_SPRINT_EVENT("PlayerActiveSprintEvent"),
    PLAYER_DESACTIVE_SPRINT_EVENT("PlayerDesactiveSprintEvent");
    /*PLAYER_WRITE_COMMAND_EVENT,
    PLAYER_UNEQUIP_THE_EI_EVENT*/

    public String name;

    EventName(String name){
        this.name = name;
    }
}
