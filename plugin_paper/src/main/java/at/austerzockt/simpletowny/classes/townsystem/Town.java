package at.austerzockt.simpletowny.classes.townsystem;

import at.austerzockt.simpletowny.classes.Towny;
import org.bukkit.entity.Player;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Town {

    private String name;
    private ArrayList<Vector2> area = new ArrayList<>();
    private Nation nation;
    private Player major;
    public boolean hasNation;

    public Town(String name, Player major) throws SQLException {
        this.name = name;
        this.major = major;
        Statement statement = Towny.getDatabaseAccess().createStatement();
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS " + name + "_area(x int, z int)");
        statement.executeUpdate("INSERT INTO towns(name, nation, major) VALUES ('" + name + "','" + null + "','" + major.getUniqueId() + "')");
        ResultSet rs = statement.executeQuery("SELECT * FROM " + name + "_area");
        while (rs.next()) {
            area.add(new Vector2(rs.getInt("x"), rs.getInt("z")));
        }
    }

    public void addChunk(Vector2 chunk) {
        int x = chunk.x;
        int z = chunk.z;
        try {
            Towny.getDatabaseAccess().createStatement().executeUpdate("INSERT INTO " + name + "_area (x, z) VALUES (" + x + "," + z + ")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
