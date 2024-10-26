package com.ssomar.sevents.events.player.jump;

import org.bukkit.Bukkit;
import org.bukkit.Input;
import org.bukkit.Statistic;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInputEvent;
import org.bukkit.event.player.PlayerStatisticIncrementEvent;

public class PlayerJumpListener1v21v3 implements Listener {

    @EventHandler
    public void onPlayerStatisticIncrementEvent(PlayerInputEvent e) {
        if (e.getInput().isJump()) {
            PlayerJumpEvent playerJumpEvent = new PlayerJumpEvent(e.getPlayer());
            Bukkit.getServer().getPluginManager().callEvent(playerJumpEvent);
        }
    }
}
