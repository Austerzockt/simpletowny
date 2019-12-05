package at.austerzockt.simpletowny.classes.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    private static Connection connection;
    private static String databasehost, databasename, databaseuser, databasepw;
    private static int databaseport;
    public DatabaseManager() {
        databasehost = "127.0.0.1";
        databasename = "towny";
        databaseuser = "root";
        databasepw = "";
        databaseport = 3306;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://" + databasehost + ":" + databaseport + "/" + databasename, databaseuser, databasepw);
            connection.setAutoCommit(true);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public Statement createStatement()  {
        try {
            return connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Well SQL is annoying :p");
        }
    }
    //GETTERS
    //TODO: maybe Setters?
    public Connection getConnection() {

        return connection;
    }

    public int getPort() {
        return databaseport;
    }

    public String getPassword() {
        return databasepw;
    }

    public String getName() {
        return databasename;
    }

    public String getHost() {
        return databasehost;
    }



}
