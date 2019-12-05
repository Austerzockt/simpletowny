package at.austerzockt.simpletowny.classes.database;

import at.austerzockt.simpletowny.classes.Towny;

import java.sql.SQLException;
import java.sql.Statement;

public class TownyStatement {
    Statement statement;

    public TownyStatement() {
        try {
            statement = Towny.getDatabaseAccess().getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}

