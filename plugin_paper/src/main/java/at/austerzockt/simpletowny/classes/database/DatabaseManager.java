package at.austerzockt.simpletowny.classes.database;

import org.bukkit.Bukkit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static Connection connection;
    private static String databasehost, databasename, databaseuser, databasepw;
    private static int databaseport;

    public DatabaseManager() {
        databasehost = "127.0.0.1";
        databasename = "towny";
        databaseuser = "root";
        databasepw = "";
        databaseport = 3308;


        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://" + databasehost + ":" + databaseport + "/" + databasename, databaseuser, databasepw);
            connection.setAutoCommit(false);
            Bukkit.getConsoleSender().sendMessage(connection.getClientInfo().toString());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

}
