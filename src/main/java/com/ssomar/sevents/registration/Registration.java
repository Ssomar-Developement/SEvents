package com.ssomar.sevents.registration;

import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Registration {

    /* The plugin where the Listener is hosted */
    private JavaPlugin host;

    /* The other plugins that uses this listener */
    private List<JavaPlugin> plugins;

    private List<Listener> listener;

    public Registration(JavaPlugin plugin,List<Listener> listener){
        this.host = plugin;
        this.plugins = new ArrayList<>();
        this.listener = listener;
    }

    public boolean isHost(JavaPlugin plugin){
        return this.host.equals(plugin);
    }

    // #TODO METTRE UN LISTENER QUI CHECK QUAND UN PLUGIN SE UNLOAD SI LE PLUGIN EST HOST, IL FAUT TRANSFER
    public boolean transferHost(){
        if(size() > 0){
            unregister();
            host = plugins.get(0);
            register();
            return true;
        }
        return false;

    }

    public void register(){
        for(Listener l : listener){
            host.getServer().getPluginManager().registerEvents(l, host);
        }
    }

    public void unregister(){
        for(Listener l : listener){
            HandlerList.unregisterAll(l);
        }
    }

    public List<Listener> getListener() {
        return listener;
    }

    public int size(){
        return plugins.size();
    }

    public boolean contains(JavaPlugin plugin){
        return plugins.contains(plugin);
    }

    public void addPlugin(JavaPlugin plugin){
        plugins.add(plugin);
    }

    public boolean removePlugin(JavaPlugin plugin){
        plugins.remove(plugin);
        return plugins.size() == 0;
    }
}
