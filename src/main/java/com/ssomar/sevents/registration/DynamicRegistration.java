package com.ssomar.sevents.registration;

import com.ssomar.sevents.EventName;
import com.ssomar.sevents.SEventFactory;
import com.ssomar.sevents.events.player.click.InteractionMarkerManager;
import com.ssomar.sevents.events.player.click.InteractionMarkerQuitListener;
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

    /* Plugin currently hosting the interaction-marker quit-cleanup listener.
     * If it gets disabled, Bukkit silently unregisters the listener, so we must
     * re-register with the next plugin that calls register(). */
    private JavaPlugin quitCleanupHost = null;

    public DynamicRegistration() {
        registered = new HashMap<>();
        Version.initVersion();
    }

    public void register(EventName eventName, JavaPlugin plugin) {
        initInteractionMarkers(plugin);
        if (!registered.containsKey(eventName)) {
            SEventFactory factory = new SEventFactory();
            List<Listener> listener = factory.getSEvent(eventName).getChildListener();
            Registration registration;
            registered.put(eventName, (registration = new Registration(plugin, listener)));
            registration.register();
        } else {
            Registration registration = registered.get(eventName);
            if(!registration.contains(plugin)) registration.addPlugin(plugin);
        }
    }

    /* Wire the per-click interaction markers: give them a plugin to schedule their
     * self-heal, and keep the quit-cleanup safety net registered with an enabled plugin
     * (its listener dies silently with its host when that plugin gets disabled). */
    private void initInteractionMarkers(JavaPlugin plugin) {
        InteractionMarkerManager.init(plugin);
        if (plugin == null || plugin.equals(quitCleanupHost)) return;
        if (quitCleanupHost == null || !quitCleanupHost.isEnabled()) {
            plugin.getServer().getPluginManager().registerEvents(new InteractionMarkerQuitListener(), plugin);
            quitCleanupHost = plugin;
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
