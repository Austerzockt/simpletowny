package at.austerzockt.simpletowny.classes.command.commands;

import at.austerzockt.simpletowny.classes.Towny;
import at.austerzockt.simpletowny.classes.command.TownyCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.SQLException;

public class TestCommand extends TownyCommand {

    public TestCommand() {
        super("test", "test", true);
    }

    @Override
    public void execute(CommandSender sender, String[] args, Player p) {
        int x = 0;
        if (args.length == 1) {

            do {
                x++;
                try {
                    Towny.getDatabaseAccess().getConnection().createStatement().executeUpdate(String.format("INSERT INTO towns(name) VALUES ('%d') ", x));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } while (x < 123);


        } else {
            try {
                String fasd = "fasd";
                Towny.getDatabaseAccess().getConnection().createStatement().executeUpdate(String.format("DELETE from towns WHERE name = '%s'", fasd));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
