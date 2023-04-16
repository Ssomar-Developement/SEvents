package com.ssomar.sevents;

import com.ssomar.sevents.events.block.SBlockDryEvent;
import com.ssomar.sevents.events.player.beforedeath.SPlayerBeforeDeathEvent;
import com.ssomar.sevents.events.player.click.left.SPlayerLeftClickEvent;
import com.ssomar.sevents.events.player.click.onentity.left.SPlayerLeftClickOnEntityEvent;
import com.ssomar.sevents.events.player.click.onentity.right.SPlayerRightClickOnEntityEvent;
import com.ssomar.sevents.events.player.click.onplayer.left.SPlayerLeftClickOnPlayerEvent;
import com.ssomar.sevents.events.player.click.onplayer.right.SPlayerRightClickOnPlayerEvent;
import com.ssomar.sevents.events.player.click.right.SPlayerRightClickEvent;
import com.ssomar.sevents.events.player.equip.armor.SPlayerEquipArmorEvent;
import com.ssomar.sevents.events.player.fish.block.SPlayerFishBlockEvent;
import com.ssomar.sevents.events.player.fish.entity.SPlayerFishEntityEvent;
import com.ssomar.sevents.events.player.fish.fish.SPlayerFishFishEvent;
import com.ssomar.sevents.events.player.fish.nothing.SPlayerFishNothingEvent;
import com.ssomar.sevents.events.player.fish.player.SPlayerFishPlayerEvent;
import com.ssomar.sevents.events.player.fly.active.SPlayerActiveFlyEvent;
import com.ssomar.sevents.events.player.fly.desactive.SPlayerDesactiveFlyEvent;
import com.ssomar.sevents.events.player.jump.SPlayerJumpEvent;
import com.ssomar.sevents.events.player.kill.entity.SPlayerKillEntityEvent;
import com.ssomar.sevents.events.player.kill.player.SPlayerKillPlayerEvent;
import com.ssomar.sevents.events.player.press.SPlayerPressPlateEvent;
import com.ssomar.sevents.events.player.receivehit.byentity.SPlayerReceiveHitByEntityEvent;
import com.ssomar.sevents.events.player.receivehit.byplayer.SPlayerReceiveHitByPlayerEvent;
import com.ssomar.sevents.events.player.receivehit.global.SPlayerReceiveHitGlobalEvent;
import com.ssomar.sevents.events.player.sneak.active.SPlayerActiveSneakEvent;
import com.ssomar.sevents.events.player.sneak.desactive.SPlayerDesactiveSneakEvent;
import com.ssomar.sevents.events.player.sprint.active.SPlayerActiveSprintEvent;
import com.ssomar.sevents.events.player.sprint.desactive.SPlayerDesactiveSprintEvent;
import com.ssomar.sevents.events.player.tramplecrop.SPlayerTrampleCropEvent;
import com.ssomar.sevents.events.projectile.hitblock.SProjectileHitBlockEvent;
import com.ssomar.sevents.events.projectile.hitentity.SProjectileHitEntityEvent;
import com.ssomar.sevents.events.projectile.hitplayer.SProjectileHitPlayerEvent;

public class SEventFactory {

    public SEvent getSEvent(EventName eventName) {
        switch (eventName) {
            case BLOCK_DRY:
                return new SBlockDryEvent();

            case PLAYER_RIGHT_CLICK_EVENT:
                return new SPlayerRightClickEvent();
            case PLAYER_RIGHT_CLICK_ON_ENTITY_EVENT:
                return new SPlayerRightClickOnEntityEvent();
            case PLAYER_RIGHT_CLICK_ON_PLAYER_EVENT:
                return new SPlayerRightClickOnPlayerEvent();

            case PLAYER_LEFT_CLICK_EVENT:
                return new SPlayerLeftClickEvent();
            case PLAYER_LEFT_CLICK_ON_PLAYER_EVENT:
                return new SPlayerLeftClickOnPlayerEvent();
            case PLAYER_LEFT_CLICK_ON_ENTITY_EVENT:
                return new SPlayerLeftClickOnEntityEvent();

            case PLAYER_FISH_FISH_EVENT:
                return new SPlayerFishFishEvent();
            case PLAYER_FISH_PLAYER_EVENT:
                return new SPlayerFishPlayerEvent();
            case PLAYER_FISH_ENTITY_EVENT:
                return new SPlayerFishEntityEvent();
            case PLAYER_FISH_BLOCK_EVENT:
                return new SPlayerFishBlockEvent();
            case PLAYER_FISH_NOTHING_EVENT:
                return new SPlayerFishNothingEvent();

            case PLAYER_ACTIVE_SNEAK_EVENT:
                return new SPlayerActiveSneakEvent();
            case PLAYER_DESACTIVE_SNEAK_EVENT:
                return new SPlayerDesactiveSneakEvent();

            case PLAYER_ACTIVE_SPRINT_EVENT:
                return new SPlayerActiveSprintEvent();
            case PLAYER_DESACTIVE_SPRINT_EVENT:
                return new SPlayerDesactiveSprintEvent();

            case PLAYER_ACTIVE_FLY_EVENT:
                return new SPlayerActiveFlyEvent();
            case PLAYER_DESACTIVE_FLY_EVENT:
                return new SPlayerDesactiveFlyEvent();

            case PLAYER_JUMP_EVENT:
                return new SPlayerJumpEvent();

            case PLAYER_KILL_PLAYER_EVENT:
                return new SPlayerKillPlayerEvent();
            case PLAYER_KILL_ENTITY_EVENT:
                return new SPlayerKillEntityEvent();

            case PLAYER_RECEIVE_HIT_BY_PLAYER_EVENT:
                return new SPlayerReceiveHitByPlayerEvent();
            case PLAYER_RECEIVE_HIT_BY_ENTITY_EVENT:
                return new SPlayerReceiveHitByEntityEvent();
            case PLAYER_RECEIVE_HIT_GLOBAL_EVENT:
                return new SPlayerReceiveHitGlobalEvent();

            case PLAYER_BEFORE_DEATH_EVENT:
                return new SPlayerBeforeDeathEvent();

            case PLAYER_EQUIP_ARMOR_EVENT:
                return new SPlayerEquipArmorEvent();

            case PLAYER_PRESS_PLATE_EVENT:
                return new SPlayerPressPlateEvent();

            case PLAYER_TRAMPLE_CROP_EVENT:
                return new SPlayerTrampleCropEvent();

            case PROJECTILE_HIT_BLOCK:
                return new SProjectileHitBlockEvent();
            case PROJECTILE_HIT_ENTITY:
                return new SProjectileHitEntityEvent();
            case PROJECTILE_HIT_PLAYER:
                return new SProjectileHitPlayerEvent();

            default:
                return null;
        }

    }
}
