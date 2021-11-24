package com.ssomar.sevents.registration;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEventFactory;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class DynamicRegistration {

    public static DynamicRegistration instance;

    public List<EventName> registered;

    public DynamicRegistration(){
        registered = new ArrayList<>();
    }

    public void register(EventName eventName, JavaPlugin plugin){
        if(!registered.contains(eventName)){
            SEventFactory factory = new SEventFactory();
            plugin.getServer().getPluginManager().registerEvents(factory.getSEvent(eventName).getChildListener(), plugin);
        }
    }

    public static DynamicRegistration getInstance(){
        if(instance == null) instance = new DynamicRegistration();
        return instance;
    }
}
