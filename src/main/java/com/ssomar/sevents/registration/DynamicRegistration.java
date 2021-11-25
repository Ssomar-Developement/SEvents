package com.ssomar.sevents.registration;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEventFactory;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicRegistration {

    public static DynamicRegistration instance;

    public Map<EventName, Registration> registered;

    public DynamicRegistration() {
        registered = new HashMap<>();
    }

    public void register(EventName eventName, JavaPlugin plugin) {
        if (!registered.containsKey(eventName)) {
            Map<JavaPlugin, Listener> registration = new HashMap<>();
            SEventFactory factory = new SEventFactory();
            Listener listener = factory.getSEvent(eventName).getChildListener();
            registered.put(eventName, new Registration(plugin, listener));
            plugin.getServer().getPluginManager().registerEvents(listener, plugin);
        } else {
            registered.get(eventName).addPlugin(plugin);
        }
    }

    public void unregister(EventName eventName, JavaPlugin plugin) {
        if (registered.containsKey(eventName)) {
            Registration registration = registered.get(eventName);
            if (registration.contains(plugin)) {
                if (registration.size() == 1) {
                    HandlerList.getRegisteredListeners(plugin).remove(registration.getListener());
                }
                if (registration.removePlugin(plugin)) {
                    registered.remove(eventName);
                }
            }
        }
    }

    public static DynamicRegistration getInstance() {
        if (instance == null) instance = new DynamicRegistration();
        return instance;
    }
}
