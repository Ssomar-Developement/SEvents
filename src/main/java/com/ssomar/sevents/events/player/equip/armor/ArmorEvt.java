package com.ssomar.sevents.events.player.equip.armor;

import com.ssomar.executableitems.events.EventInfos;
import com.ssomar.executableitems.events.EventsManager;
import com.ssomar.executableitems.items.activators.option.Option;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.ArrayList;

public class ArmorEvt implements Listener{

	@EventHandler
	public void equip(com.ssomar.executableitems.events.armor.ArmorEquipEvent event){
		Player p = event.getPlayer();
		
		/* PLAYER_EQUIP_THE_EI */
		EventInfos eInfo = new EventInfos(event, new com.ssomar.executableitems.events.armor.PlayerEquipTheEIEvent(p));
		eInfo.setPlayer(p);
		
		// Force mainhand because there is no slot needed for this activator
		eInfo.setForceMainHand(true);

		EventsManager.getInstance().activeOptionForPlayerForItemStack(Option.PLAYER_EQUIP_THE_EI, p, event.getNewArmorPiece(), -1, eInfo, new ArrayList<>());
		
		
		/* PLAYER_UNEQUIP_THE_EI */
		EventInfos eInfo2 = new EventInfos(event, new PlayerUnequipTheEIEvent(p));
		eInfo2.setPlayer(p);
		
		// Force mainhand because there is no slot needed for this activator
		eInfo2.setForceMainHand(true);

		EventsManager.getInstance().activeOptionForPlayerForItemStack(Option.PLAYER_UNEQUIP_THE_EI, p, event.getOldArmorPiece(), -1, eInfo2, new ArrayList<>());
	
	}
}
