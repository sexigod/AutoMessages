package br.com.thiagocodero.automessages;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

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
