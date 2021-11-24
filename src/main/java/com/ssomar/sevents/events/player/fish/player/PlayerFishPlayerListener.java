package com.ssomar.sevents.events.player.fish.player;

import com.ssomar.sevents.events.player.click.left.PlayerLeftClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

import java.util.ArrayList;

public class PlayerFishPlayerListener  implements Listener {

    @EventHandler
    public void onPlayerFishEvent(PlayerFishEvent e) {

        if(e.getState().equals(PlayerFishEvent.State.CAUGHT_ENTITY)) {
            Entity ent = e.getCaught();
            if(ent instanceof Player) {
                PlayerFishPlayerEvent playerFishPlayerEvent = new PlayerFishPlayerEvent((Player) e.getPlayer(), (Player)ent);
                Bukkit.getServer().getPluginManager().callEvent(playerFishPlayerEvent);
                if (playerFishPlayerEvent.isCancelled()) {
                    e.setCancelled(true);
                }
            }
        }
    }
}
