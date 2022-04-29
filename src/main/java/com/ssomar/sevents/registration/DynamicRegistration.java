package com.ssomar.sevents.registration;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEventFactory;
import com.ssomar.sevents.version.Version;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicRegistration {

    private static DynamicRegistration instance;

    private Map<EventName, Registration> registered;

    public DynamicRegistration() {
        registered = new HashMap<>();
        Version.initVersion();
    }

    public void register(EventName eventName, JavaPlugin plugin) {
        if (!registered.containsKey(eventName)) {
            SEventFactory factory = new SEventFactory();
            Listener listener = factory.getSEvent(eventName).getChildListener();
            Registration registration;
            registered.put(eventName, (registration = new Registration(plugin, listener)));
            registration.register();
        } else {
            Registration registration = registered.get(eventName);
            if(!registration.contains(plugin)) registration.addPlugin(plugin);
        }
    }

    public void unregister(EventName eventName, JavaPlugin plugin) {
        if (registered.containsKey(eventName)) {
            Registration registration = registered.get(eventName);
            if (registration.isHost(plugin)) {
                if(!registration.transferHost()){
                    registration.unregister();
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
