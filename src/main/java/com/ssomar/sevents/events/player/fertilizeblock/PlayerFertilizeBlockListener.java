package com.ssomar.sevents.events.player.fertilizeblock;

import com.ssomar.sevents.events.player.beforedeath.PlayerBeforeDeathEvent;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFertilizeEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.ArrayList;

public class PlayerFertilizeBlockListener implements Listener {

    @EventHandler
    public void onBlockFertilizeEvent(BlockFertilizeEvent e) {
        if(e.getPlayer() != null) {
            Player p = e.getPlayer();
            Block b = e.getBlock();

            PlayerFertilizeBlockEvent playerFertilizeBlockEvent = new PlayerFertilizeBlockEvent(p, b);
            Bukkit.getServer().getPluginManager().callEvent(playerFertilizeBlockEvent);
            if (playerFertilizeBlockEvent.isCancelled()) {
                e.setCancelled(true);
            };
        }
    }
}
