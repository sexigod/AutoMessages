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
                    "#Time to start the automessages task\n" +
                    "  StartDelayInSeconds: 10\n" +
                    "\n" +
                    "#Delay in Seconds to wait until the next message show\n" +
                    "  DelayInSeconds: 10\n" +
                    "  \n" +
                    "#Message to show in it's time\n" +
                    "  '1':\n" +
                    "  \n" +
                    "#&h = has hover\n" +
                    "#&u = has url\n" +
                    "    Text: '&hHover1_Example1 &h&u&lHover2_With_URL1_Example1'\n" +
                    "    \n" +
                    "#1st Hovered text by the 1st \"&h\" word occurrence\n" +
                    "    Hover1: 'Hover1_Example1'\n" +
                    "    \n" +
                    "#2nd Hovered text by the 2nd \"&h\" word occurrence\n" +
                    "    Hover2: '&lFollow &4&l<3'\n" +
                    "    \n" +
                    "#1st URL link by the 1st \"&u\" word occurrence\n" +
                    "    URL1: https://github.com/thiagocodero\n" +
                    "    \n" +
                    "#Sound to play when message appear\n" +
                    "    Sound: UI_TOAST_IN\n" +
                    "\n" +
                    "  '2':\n" +
                    "    Text: '&b&lColoured &h&a&lHover1&r_&e&lExample2 &h&u&3&lHover2&r_&d&lWith&r_&5&lURL1&r_&9&lExample2 &h&u&3&lHover3&r_&d&lWith&r_&2&lURL2&r_&4&lExample2'\n" +
                    "    Hover1: '&a&lHover1&r_&e&lExample2'\n" +
                    "    Hover2: '&a&lJoin us!'\n" +
                    "    Hover3: '&3&lHover3&r_&d&lWith&r_&2&lURL2&r_&4&lExample2'\n" +
                    "    URL1: https://discord.gg/GUpt8Ex\n" +
                    "    URL2: https://github.com/thiagocodero/AutoMessages\n" +
                    "    Sound: UI_TOAST_IN\n" +
                    "    \n" +
                    "  '3':\n" +
                    "#&p = has player command\n" +
                    "    Text: '&h&p&4&lHover1&r_&b&lWith&r_&6&lCommand&r_&c&lExample1'\n" +
                    "    Hover1: '&e&lClick to run command'\n" +
                    "#1st Player Command to run when clicked by the 1st \"&p\" word occurrence\n" +
                    "    Command1: /pl\n" +
                    "    ");
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
