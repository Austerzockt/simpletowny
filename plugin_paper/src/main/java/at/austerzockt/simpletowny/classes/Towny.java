package at.austerzockt.simpletowny.classes;

import org.bukkit.plugin.java.JavaPlugin;


public class Towny extends JavaPlugin {
    public static Towny INSTANCE;
    @Override
    public void onEnable() {
        INSTANCE = this;
    }

    @Override
    public void onDisable() {

    }
}
