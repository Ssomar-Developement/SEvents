package com.ssomar.sevents;

import com.ssomar.sevents.events.block.SBlockDryEvent;
import com.ssomar.sevents.events.entity.beforedeath.SEntityBeforeDeathEvent;
import com.ssomar.sevents.events.player.beforedeath.SPlayerBeforeDeathEvent;
import com.ssomar.sevents.events.player.brush.SPlayerBrushBlockEvent;
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
import com.ssomar.sevents.events.player.fly.enable.SPlayerEnableFlyEvent;
import com.ssomar.sevents.events.player.fly.disable.SPlayerDisableFlyEvent;
import com.ssomar.sevents.events.player.glide.enable.SPlayerEnableGlideEvent;
import com.ssomar.sevents.events.player.glide.disable.SPlayerDisableGlideEvent;
import com.ssomar.sevents.events.player.jump.SPlayerJumpEvent;
import com.ssomar.sevents.events.player.kill.entity.SPlayerKillEntityEvent;
import com.ssomar.sevents.events.player.kill.entity.participate.entity.SEntityParticipateKillEntityEvent;
import com.ssomar.sevents.events.player.kill.entity.participate.player.SPlayerParticipateKillEntityEvent;
import com.ssomar.sevents.events.player.kill.player.SPlayerKillPlayerEvent;
import com.ssomar.sevents.events.player.kill.player.participate.entity.SEntityParticipateKillPlayerEvent;
import com.ssomar.sevents.events.player.kill.player.participate.player.SPlayerParticipateKillPlayerEvent;
import com.ssomar.sevents.events.player.press.SPlayerPressPlateEvent;
import com.ssomar.sevents.events.player.receivehit.byentity.SPlayerReceiveHitByEntityEvent;
import com.ssomar.sevents.events.player.receivehit.byplayer.SPlayerReceiveHitByPlayerEvent;
import com.ssomar.sevents.events.player.receivehit.global.SPlayerReceiveHitGlobalEvent;
import com.ssomar.sevents.events.player.sneak.enable.SPlayerEnableSneakEvent;
import com.ssomar.sevents.events.player.sneak.disable.SPlayerDisableSneakEvent;
import com.ssomar.sevents.events.player.sprint.enable.SPlayerEnableSprintEvent;
import com.ssomar.sevents.events.player.sprint.disable.SPlayerDisableSprintEvent;
import com.ssomar.sevents.events.player.tramplecrop.SPlayerTrampleCropEvent;
import com.ssomar.sevents.events.projectile.hitblock.SProjectileHitBlockEvent;
import com.ssomar.sevents.events.projectile.hitentity.SProjectileHitEntityEvent;
import com.ssomar.sevents.events.projectile.hitplayer.SProjectileHitPlayerEvent;

public class SEventFactory {

    public SEvent getSEvent(EventName eventName) {
        switch (eventName) {
            case BLOCK_DRY:
                return new SBlockDryEvent();

            case ENTITY_PARTICIPATE_KILL_ENTITY_EVENT:
                return new SEntityParticipateKillEntityEvent();
            case ENTITY_PARTICIPATE_KILL_PLAYER_EVENT:
                return new SEntityParticipateKillPlayerEvent();
            case PLAYER_BRUSH_BLOCK_EVENT:
                return new SPlayerBrushBlockEvent();

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

            case PLAYER_ENABLE_SNEAK_EVENT:
                return new SPlayerEnableSneakEvent();
            case PLAYER_DISABLE_SNEAK_EVENT:
                return new SPlayerDisableSneakEvent();

            case PLAYER_ENABLE_SPRINT_EVENT:
                return new SPlayerEnableSprintEvent();
            case PLAYER_DISABLE_SPRINT_EVENT:
                return new SPlayerDisableSprintEvent();

            case PLAYER_ENABLE_FLY_EVENT:
                return new SPlayerEnableFlyEvent();
            case PLAYER_DISABLE_FLY_EVENT:
                return new SPlayerDisableFlyEvent();

            case PLAYER_ENABLE_GLIDE_EVENT:
                return new SPlayerEnableGlideEvent();
            case PLAYER_DISABLE_GLIDE_EVENT:
                return new SPlayerDisableGlideEvent();

            case PLAYER_JUMP_EVENT:
                return new SPlayerJumpEvent();

            case PLAYER_KILL_PLAYER_EVENT:
                return new SPlayerKillPlayerEvent();
            case PLAYER_KILL_ENTITY_EVENT:
                return new SPlayerKillEntityEvent();

            case PLAYER_PARTICIPATE_KILL_ENTITY_EVENT:
                return new SPlayerParticipateKillEntityEvent();
            case PLAYER_PARTICIPATE_KILL_PLAYER_EVENT:
                return new SPlayerParticipateKillPlayerEvent();

            case PLAYER_RECEIVE_HIT_BY_PLAYER_EVENT:
                return new SPlayerReceiveHitByPlayerEvent();
            case PLAYER_RECEIVE_HIT_BY_ENTITY_EVENT:
                return new SPlayerReceiveHitByEntityEvent();
            case PLAYER_RECEIVE_HIT_GLOBAL_EVENT:
                return new SPlayerReceiveHitGlobalEvent();

            case ENTITY_BEFORE_DEATH_EVENT:
                return new SEntityBeforeDeathEvent();

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
