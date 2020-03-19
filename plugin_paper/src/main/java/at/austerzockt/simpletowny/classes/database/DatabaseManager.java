package at.austerzockt.simpletowny.classes.database;

import java.sql.*;

public class DatabaseManager {
    private String errormessage = "SQLException";
    private Connection connection;
    private  final String databasehost, databasename, databaseuser, databasepw;
    private final int databaseport;
    private Statement statement;
    private DatabaseCreator databaseCreator;
    public DatabaseManager() {
        Connection connection1;
        databasehost = "127.0.0.1";
        databasename = "towny";
        databaseuser = "root";
        databasepw = "";
        databaseport = 3306;

        try {

            connection = DriverManager.getConnection(
                    "jdbc:mysql://" + databasehost + ":" + databaseport + "/" + databasename, databaseuser, databasepw);
            connection.setAutoCommit(true);
            statement = connection.createStatement();
            databaseCreator = new DatabaseCreatorImpl(connection);
            databaseCreator.create();
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
            assert statement != null;
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

public interface DatabaseCreator {
        public void create() throws SQLException;


}

}
