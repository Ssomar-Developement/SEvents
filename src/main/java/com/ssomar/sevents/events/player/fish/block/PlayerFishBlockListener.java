package com.ssomar.sevents.events.player.fish.block;

import com.ssomar.sevents.events.player.fish.fish.PlayerFishFishEvent;
import com.ssomar.sevents.version.Version;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

public class PlayerFishBlockListener implements Listener {

    @EventHandler
    public void onPlayerFishEvent(PlayerFishEvent e) {
        if (e.getState().equals(PlayerFishEvent.State.IN_GROUND) && !Version._1_12.is()) {
            Location loc = e.getHook().getLocation();
            loc.subtract(0, 1, 0);

            Block b = loc.getBlock();
            PlayerFishBlockEvent playerFishBlockEvent = new PlayerFishBlockEvent((Player) e.getPlayer(), b);
            Bukkit.getServer().getPluginManager().callEvent(playerFishBlockEvent);
            if (playerFishBlockEvent.isCancelled()) {
                e.setCancelled(true);
            }
        }
    }
}
