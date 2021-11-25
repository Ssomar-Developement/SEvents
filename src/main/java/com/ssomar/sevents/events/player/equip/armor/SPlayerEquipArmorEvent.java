package com.ssomar.sevents.events.player.equip.armor;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import com.ssomar.sevents.events.player.fertilizeblock.PlayerFertilizeBlockListener;
import org.bukkit.event.Listener;

public class SPlayerEquipArmorEvent extends SEvent {

    public SPlayerEquipArmorEvent() {
        super(EventName.PLAYER_EQUIP_ARMOR_EVENT);
    }

    @Override
    public Listener getChildListener() {
        return new PlayerFertilizeBlockListener();
    }
}
