package com.ssomar.sevents.events.player.click;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

/**
 * Base class for the per-click interaction markers (Transmit / TooMany / CancelOffHand).
 *
 * These maps are short-lived hand-off signals between paired Bukkit events, e.g.
 * PlayerInteractAtEntityEvent -> PlayerInteractEntityEvent, main-hand -> off-hand,
 * or a right-click -> the phantom left-click(s) some items generate. A marker is put
 * by the first event and consumed (removed) by the follow-up event, normally within
 * the same or the next server tick.
 *
 * The bug: if the follow-up event never fires (right-click on an armor stand does not
 * generate PlayerInteractEntityEvent, Bedrock/Geyser players, cancelled air-clicks...),
 * the marker leaks forever. Because it is a static singleton keyed only by UUID, every
 * later interaction of that player then hits the stale marker and gets wrongly cancelled,
 * until the server restarts.
 *
 * The fix: a marker self-expires a few ticks after it was set. The delay must be > 1 tick:
 * the scheduler heartbeat runs BEFORE packet processing within a tick, and some legit
 * consumers live in a separate packet (off-hand interact, phantom left-click swings) that
 * can land one tick later under network jitter. HEAL_DELAY_TICKS = 3 keeps those pairs
 * working while capping a stale marker's lifetime at ~150ms instead of "until restart".
 *
 * Each put() is stamped with a monotonically increasing generation; the scheduled sweep
 * only removes the marker if its generation is unchanged, so a re-put or a legit
 * consume/re-arm inside the window is never wrongly swept (value equality would collide
 * when the same value is re-put).
 */
public abstract class InteractionMarkerManager extends HashMap<UUID, Integer> {

    public static final long HEAL_DELAY_TICKS = 3L;

    /* Host plugin used to schedule the self-heal tasks. Shared by all subclasses. */
    private static JavaPlugin plugin;

    /* Monotonic stamp source; single-threaded (main thread only), no atomicity needed. */
    private static long stampCounter = 0;

    /* Generation stamp of the latest put() per player. */
    private final HashMap<UUID, Long> stamps = new HashMap<>();

    /** Called on every SEvents registration; keeps the freshest enabled plugin. */
    public static void init(JavaPlugin pl) {
        if (pl != null) plugin = pl;
    }

    /** Schedule a task guarded against shutdown/unsupported schedulers (e.g. Folia). */
    public static boolean runLater(Runnable task, long delayTicks) {
        if (plugin == null || !plugin.isEnabled()) return false;
        try {
            Bukkit.getScheduler().runTaskLater(plugin, task, delayTicks);
            return true;
        } catch (RuntimeException ignored) {
            /* Scheduler unavailable (shutdown, or a platform like Folia).
             * The quit cleanup listener is the remaining safety net. */
            return false;
        }
    }

    @Override
    public Integer put(UUID key, Integer value) {
        Integer previous = super.put(key, value);
        final long stamp = ++stampCounter;
        stamps.put(key, stamp);
        runLater(() -> {
            /* Only sweep if nothing consumed (remove clears the stamp) or re-armed
             * (a newer put bumped the stamp) the marker in the meantime. */
            Long current = stamps.get(key);
            if (current != null && current == stamp) {
                stamps.remove(key);
                super.remove(key);
            }
        }, HEAL_DELAY_TICKS);
        return previous;
    }

    @Override
    public Integer remove(Object key) {
        stamps.remove(key);
        return super.remove(key);
    }
}
