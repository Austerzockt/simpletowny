package at.austerzockt.simpletowny.classes.command.commands;

import at.austerzockt.simpletowny.classes.Towny;
import at.austerzockt.simpletowny.classes.command.TownyCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestCommand extends TownyCommand {

    public TestCommand(TabCompleter tabCompleter) {
        super("test", "test", true, tabCompleter);
    }

    @Override
    public void execute(CommandSender sender, String[] args, Player p) {
        int x = 0;
        if (args.length == 1) {
        }
        Towny.getDatabaseAccess().executeUpdate("INSERT into table1(chara) values('x')");
        try {
            ResultSet rs = Towny.getDatabaseAccess().executeQuery("SELECT * FROM table1 WHERE chara = 'x'");
            while (rs.next()) {
                p.sendMessage(rs.getString("chara"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

