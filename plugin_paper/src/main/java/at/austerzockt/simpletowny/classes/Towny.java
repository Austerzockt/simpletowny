package at.austerzockt.simpletowny.classes;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public class Towny extends JavaPlugin {
    @Override
    public void onEnable() {
        at.austerzockt.simpletowny.classes.messages.Towny towny = at.austerzockt.simpletowny.classes.messages.Towny.create();

        Bukkit.getConsoleSender().sendMessage(towny.test);
    }

    @Override
    public void onDisable() {

    }
}
