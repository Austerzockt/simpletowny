package at.austerzockt.simpletowny.classes.utils.chat;

import at.austerzockt.simpletowny.classes.Towny;
import org.bukkit.Bukkit;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class PlayerPrefixManager {
    public PrefixParser parser;

    public PlayerPrefixManager() {
        parser = new PrefixParser();
        parser.parse();


    }

    public static class PrefixParser {

        public HashMap<String, Prefix> prefixes = new HashMap<>();

        public HashMap<String, Prefix> parse() {
            try {
                ResultSet rs = Towny.getDatabaseAccess().createStatement().executeQuery("SELECT * FROM prefixes");
                while (rs.next()) {
                    prefixes.put(rs.getString("name"), new Prefix(rs.getString("prefix"), rs.getString("messagecolor")));


                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Bukkit.broadcastMessage(prefixes.toString());

            return prefixes;
        }
    }
}
