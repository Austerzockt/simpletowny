package at.austerzockt.bungeesystem;

import java.sql.*;
import java.util.LinkedList;
import java.util.Queue;

public class DataBaseConnectivity {
    private String errormessage = "SQLException";
    private Connection connection;
    private String databasehost, databasename, databaseuser, databasepw;
    private int databaseport;
    private Queue<String> queue = new LinkedList<String>();
    private Thread thread = new Thread(() -> {
        //public void run() {
        try {
            Statement statement = connection.createStatement();
            while (true) {
                for (String sql : queue) {
                    statement.execute(sql);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //  }
    });

    public DataBaseConnectivity() {
        databasehost = "127.0.0.1";
        databasename = "towny";
        databaseuser = "query";
        databasepw = "yM4f00Kr7JIV";
        System.getenv();
        databaseport = 3306;

        try {

            connection = DriverManager.getConnection(
                    "jdbc:mysql://" + databasehost + ":" + databaseport + "/" + databasename, databaseuser, databasepw);
            connection.setAutoCommit(true);
            thread.start();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public ResultSet query(String sql) {
        ResultSet rs = null;
        try {
            rs = connection.prepareStatement(sql).executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void execute(String sql) {
        queue.add(sql);

    }


}
