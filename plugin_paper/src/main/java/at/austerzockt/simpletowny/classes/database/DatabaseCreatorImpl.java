package at.austerzockt.simpletowny.classes.database;

import at.austerzockt.simpletowny.classes.Towny;
import org.bukkit.Bukkit;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseCreatorImpl implements DatabaseManager.DatabaseCreator {
    private Connection connection;

    public DatabaseCreatorImpl(Connection connection) {
        if (connection == null) Bukkit.getServer().getPluginManager().disablePlugin(Towny.INSTANCE);
        else {
            this.connection = connection;

        }
    }


    @Override
    public void create() throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS table1 (chara varchar(234))");
    }
}