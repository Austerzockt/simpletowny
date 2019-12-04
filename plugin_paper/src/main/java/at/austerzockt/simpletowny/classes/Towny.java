package at.austerzockt.simpletowny.classes;

import at.austerzockt.simpletowny.classes.database.DatabaseManager;
import org.bukkit.plugin.java.JavaPlugin;


public class Towny extends JavaPlugin {
    public static Towny INSTANCE;
    public static DatabaseManager databaseManager;
    @Override
    public void onEnable() {
        INSTANCE = this;
        databaseManager = new DatabaseManager();

    }

    @Override
    public void onDisable() {

    }
}
