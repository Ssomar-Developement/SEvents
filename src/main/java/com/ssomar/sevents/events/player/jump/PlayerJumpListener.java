package com.ssomar.sevents.events.player.jump;

import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerStatisticIncrementEvent;

public class PlayerJumpListener implements Listener {

    @EventHandler
    public void onPlayerStatisticIncrementEvent(PlayerStatisticIncrementEvent e) {
        if (e.getStatistic().equals(Statistic.JUMP)) {
            PlayerJumpEvent playerJumpEvent = new PlayerJumpEvent(e.getPlayer());
            Bukkit.getServer().getPluginManager().callEvent(playerJumpEvent);
        }
    }
}
