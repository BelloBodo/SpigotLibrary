package de.bellobodo.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Random;

public class LocationFunktions {

    @Nullable
    public static Player getNearestPlayer(Location location, Collection<? extends Player> players) {
        Player nearestPlayer = null;
        double nearestDistance = 1.79769313486231570e+308d;

        for (Player player : Bukkit.getOnlinePlayers().toArray(new Player[]{})) {
            double distance = player.getLocation().distance(location);
            if (distance < nearestDistance) {
                nearestPlayer = player;
                nearestDistance = distance;
            }
        }

        return nearestPlayer;
    }
}
