package at.austerzockt.simpletowny.classes.database;

import java.sql.*;

public class DatabaseManager {
    private String errormessage = "SQLException";
    private  Connection connection;
    private  String databasehost, databasename, databaseuser, databasepw;
    private  int databaseport;
    private Statement statement;
    public DatabaseManager() {
        databasehost = "127.0.0.1";
        databasename = "towny";
        databaseuser = "query";
        databasepw = "yM4f00Kr7JIV";
        databaseport = 3306;

        try {

            connection = DriverManager.getConnection(
                    "jdbc:mysql://" + databasehost + ":" + databaseport + "/" + databasename, databaseuser, databasepw);
            connection.setAutoCommit(true);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Statement createStatement()  {
        try {
            return connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(errormessage);
        }
    }
    public void executeUpdate(String sql) {
        try {
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(errormessage);
        }
    }
    public ResultSet executeQuery(String sql) {
        try {
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(errormessage);
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
