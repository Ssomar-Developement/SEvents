package com.ssomar.sevents;

public enum EventName {

    BLOCK_DRY("BlockDryEvent"),
    ENTITY_BEFORE_DEATH_EVENT("EntityBeforeDeathEvent"),
    ENTITY_PARTICIPATE_KILL_ENTITY_EVENT("EntityParticipateKillEntityEvent"),
    ENTITY_PARTICIPATE_KILL_PLAYER_EVENT("EntityParticipateKillPlayerEvent"),
    PLAYER_LEFT_CLICK_EVENT("PlayerLeftClickEvent"),
    PLAYER_RIGHT_CLICK_EVENT("PlayerRightClickEvent"),
    PLAYER_BEFORE_DEATH_EVENT("PlayerBeforeDeathEvent"),
    /*PLAYER_DEATH_EVENT,
    PLAYER_DROP_ITEM_EVENT,
    PLAYER_DROP_THE_EI_EVENT,*/
    PLAYER_BRUSH_BLOCK_EVENT("PlayerBrushBlockEvent"),
    PLAYER_LEFT_CLICK_ON_PLAYER_EVENT("PlayerLeftClickOnPlayerEvent"),
    PLAYER_LEFT_CLICK_ON_ENTITY_EVENT("PlayerLeftClickOnEntityEvent"),
    PLAYER_RIGHT_CLICK_ON_PLAYER_EVENT("PlayerRightClickOnPlayerEvent"),
    PLAYER_RIGHT_CLICK_ON_ENTITY_EVENT("PlayerLeftClickOnPlayerEvent"),
    PLAYER_RECEIVE_HIT_BY_PLAYER_EVENT("PlayerReceiveHitByPlayerEvent"),
    PLAYER_RECEIVE_HIT_BY_ENTITY_EVENT("PlayerReceiveHitByEntityEvent"),
    PLAYER_RECEIVE_HIT_GLOBAL_EVENT("PlayerReceiveHitGlobalEvent"),
    PLAYER_KILL_ENTITY_EVENT("PlayerKillEntityEvent"),
    PLAYER_KILL_PLAYER_EVENT("PlayerKillPlayerEvent"),
    PLAYER_PARTICIPATE_KILL_ENTITY_EVENT("PlayerParticipateKillEntityEvent"),
    PLAYER_PARTICIPATE_KILL_PLAYER_EVENT("PlayerParticipateKillPlayerEvent"),
    PLAYER_FISH_BLOCK_EVENT("PlayerFishBlockEvent"),
    PLAYER_FISH_FISH_EVENT("PlayerFishFishEvent"),
    PLAYER_FISH_ENTITY_EVENT("PlayerFishEntityEvent"),
    PLAYER_FISH_NOTHING_EVENT("PlayerFishNothingEvent"),
    PLAYER_FISH_PLAYER_EVENT("PlayerFishPlayerEvent"),
    PLAYER_JUMP_EVENT("PlayerJumpEvent"),
    PLAYER_EQUIP_ARMOR_EVENT("PlayerEquipArmorEvent"),
    PLAYER_ENABLE_FLY_EVENT("PlayerEnableFlyEvent"),
    PLAYER_DISABLE_FLY_EVENT("PlayerDisableFlyEvent"),
    PLAYER_ENABLE_GLIDE_EVENT("PlayerEnableGlideEvent"),
    PLAYER_DISABLE_GLIDE_EVENT("PlayerDisableGlideEvent"),
    PLAYER_ENABLE_SNEAK_EVENT("PlayerEnableSneakEvent"),
    PLAYER_DISABLE_SNEAK_EVENT("PlayerDisableSneakEvent"),
    PLAYER_ENABLE_SPRINT_EVENT("PlayerEnableSprintEvent"),
    PLAYER_DISABLE_SPRINT_EVENT("PlayerDisableSprintEvent"),
    PLAYER_PRESS_PLATE_EVENT("PlayerPressPlateEvent"),
    PLAYER_TRAMPLE_CROP_EVENT("PlayerTrampleCropEvent"),
    PROJECTILE_HIT_BLOCK("ProjectileHitBlockEvent"),
    PROJECTILE_HIT_ENTITY("ProjectileHitEntityEvent"),
    PROJECTILE_HIT_PLAYER("ProjectileHitPlayerEvent");

    public String name;

    EventName(String name){
        this.name = name;
    }
}
