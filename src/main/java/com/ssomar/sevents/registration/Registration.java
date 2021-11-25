package com.ssomar.sevents.registration;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Registration {

    private List<JavaPlugin> plugins;

    private Listener listener;

    public Registration(JavaPlugin plugin, Listener listener){
        this.plugins = new ArrayList<>(Arrays.asList(plugin));
        this.listener = listener;
    }

    public Listener getListener() {
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
