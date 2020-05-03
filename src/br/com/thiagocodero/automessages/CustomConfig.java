package br.com.thiagocodero.automessages;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

abstract class CustomConfig {
    static final AutoMessages plugin = AutoMessages.getPlugin(AutoMessages.class);
    static FileConfiguration config;
    static File configFile = new File(plugin.getDataFolder(), "config.yml");

    static void createFiles() throws IOException {
        if (Files.notExists(plugin.getDataFolder().toPath())) {
            Files.createDirectory(plugin.getDataFolder().toPath());
        }
        if (Files.notExists(configFile.toPath())) {
            Files.createFile(configFile.toPath());
            writeContent();
        }
    }

    static FileConfiguration getConfig() {
        return config;
    }

    static void load() {
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    static void writeContent() {
        try {
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(configFile), StandardCharsets.UTF_8));
            writer.write("AutoMessages:\n" +
                    "\n" +
                    "  #18000 ticks = 15 minutes\n" +
                    "  DelayInTicks: 200\n" +
                    "\n" +
                    "  '1':\n" +
                    "    Text: '&hHover1Exemple1 &h&uHover2WithURL1Exemple1'\n" +
                    "    Hover1: Hover1Exemple1\n" +
                    "    Hover2: Hover2WithURL1Exemple1\n" +
                    "    URL1: https://github.com/thiagocodero\n" +
                    "    Sound: UI_TOAST_IN\n" +
                    "\n" +
                    "  '2':\n" +
                    "    Text: '&b&lColoured &h&a&lHover&c&l1&eExemple&c2 &h&u&3&lHover&62&d&lWith&5&lURL&61&9&lExemple&62 &h&u&3&lHover&63&d&lWith&2&lURL&c2&4&lExemple&62'\n" +
                    "    Hover1: '&a&lHover&c&l1&eExemple&c2'\n" +
                    "    Hover2: '&3&lHover&62&d&lWith&5&lURL&61&9&lExemple&62'\n" +
                    "    Hover3: '&3&lHover&63&d&lWith&2&lURL&c2&4&lExemple&62'\n" +
                    "    URL1: https://discord.gg/GUpt8Ex\n" +
                    "    URL2: https://github.com/thiagocodero/AutoMessages\n" +
                    "    Sound: ENTITY_PLAYER_LEVELUP");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String color(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
}
