package com.ssomar.sevents.events.player.kill.player;

import com.ssomar.sevents.events.player.click.right.PlayerRightClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.ArrayList;

public class PlayerKillPlayerListener implements Listener {

    @EventHandler
    public void onPlayerDeathEvent(PlayerDeathEvent e) {
        Player p = e.getEntity();
        if (p.getKiller() != null) {
            PlayerKillPlayerEvent playerKillPlayerEvent = new PlayerKillPlayerEvent(p.getKiller(), p);
            Bukkit.getServer().getPluginManager().callEvent(playerKillPlayerEvent);
        }
    }
}
