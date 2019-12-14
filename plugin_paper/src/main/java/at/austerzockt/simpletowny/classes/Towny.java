package at.austerzockt.simpletowny.classes;

import at.austerzockt.simpletowny.classes.command.Commands;
import at.austerzockt.simpletowny.classes.database.DatabaseManager;
import at.austerzockt.simpletowny.classes.utils.town.TownListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;


public class Towny extends JavaPlugin {
    public static Towny INSTANCE;
    private static DatabaseManager databaseManager;
    private static Commands commands;
    @Override
    public void onEnable() {
        INSTANCE = this;
        databaseManager = new DatabaseManager();
        commands = new Commands();
        getServer().getPluginManager().registerEvents(new TownListener(), this);

    }

    @Override
    public void onDisable() {
        try {
            if (!getDatabaseAccess().getConnection().isClosed())
            getDatabaseAccess().getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static DatabaseManager getDatabaseAccess() {
        return databaseManager;
    }
}
