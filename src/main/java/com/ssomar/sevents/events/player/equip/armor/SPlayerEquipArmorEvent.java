package com.ssomar.sevents.events.player.equip.armor;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEvent;
import com.ssomar.sevents.events.player.click.right.PlayerRightClickListener;
import com.ssomar.sevents.version.Version;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SPlayerEquipArmorEvent extends SEvent {

    public SPlayerEquipArmorEvent() {
        super(EventName.PLAYER_EQUIP_ARMOR_EVENT);
    }

    @Override
    public List<Listener> getChildListener() {
        List<Listener> listeners = new ArrayList<>();
        listeners.addAll(Arrays.asList(new PlayerEquipArmorListener()));
        if(!Version.is1v12Less()){
            listeners.addAll(Arrays.asList(new PlayerEquipArmorListenerAbove112()));
        }
        return listeners;
    }
}
