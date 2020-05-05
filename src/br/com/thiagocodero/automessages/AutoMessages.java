package br.com.thiagocodero.automessages;

import java.io.IOException;

import org.bukkit.plugin.java.JavaPlugin;

public class AutoMessages extends JavaPlugin {
    @Override
    public void onEnable() {
        try {
            CustomConfig.createFiles();
        } catch (IOException e) {
            e.printStackTrace();
        }
        CustomConfig.load();
        getServer().getConsoleSender().sendMessage(CustomConfig.color("&aAutoMessages enabled!"));
        PrintTask.start();
        new Text().get();
    }
}
