package at.austerzockt.simpletowny.classes.command.commands;

import at.austerzockt.simpletowny.classes.command.TownyCommand;
import at.austerzockt.simpletowny.classes.townsystem.Town;
import at.austerzockt.simpletowny.classes.townsystem.Vector2;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.sql.SQLException;

public class TownCommand extends TownyCommand {
    public TownCommand(TabCompleter tabCompleter) {
        super("town", "town", false, tabCompleter);
    }

    @Override
    public void execute(CommandSender sender, String[] args, Player p) {


        if (args.length == 2) {
            try {
                Town town = new Town(args[0], p);
                if (args[1].equalsIgnoreCase("setchunk")) {
                    town.addChunk(Vector2.fromChunk(p.getChunk()));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }

    }
}
