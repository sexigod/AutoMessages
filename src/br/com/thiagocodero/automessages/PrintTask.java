package br.com.thiagocodero.automessages;

import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.List;

class PrintTask extends CustomConfig {
    static List<ComponentBuilder> componentBuilders = new ArrayList<>();
    static List<Sound> sounds = new ArrayList<>();
    static int count;
    static BukkitTask bukkitTask;

    static void start() {
        bukkitTask = new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                    if (componentBuilders.size() > 0) {
                        player.sendMessage("");
                        ComponentBuilder componentBuilder = new ComponentBuilder(componentBuilders.get(count));
                        player.playSound(player.getLocation(), sounds.get(count), 1, 1);
                        player.spigot().sendMessage(componentBuilder.create());
                        player.sendMessage("");
                    }
                }
                if (componentBuilders.size() > 0) {
                    count++;
                }
                if (count == componentBuilders.size()) {
                    count = 0;
                }
            }
        }.runTaskTimerAsynchronously(plugin, 80, Integer.parseInt(getConfig().getString("AutoMessages.DelayInTicks")));
    }
}