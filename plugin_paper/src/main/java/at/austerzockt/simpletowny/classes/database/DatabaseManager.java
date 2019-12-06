package at.austerzockt.simpletowny.classes.database;

import java.sql.*;

public class DatabaseManager {
    private  Connection connection;
    private  String databasehost, databasename, databaseuser, databasepw;
    private  int databaseport;
    private Statement statement;
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
            statement = connection.createStatement();
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
    public void executeUpdate(String sql) {
        try {
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Well SQL is annoying :p");
        }
    }
    public ResultSet executeQuery(String sql) {
        try {
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Well SQL is annoying :p");
        }
    }
    //GETTERS
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
