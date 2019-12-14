package at.austerzockt.simpletowny.classes.command.commands;

import at.austerzockt.simpletowny.classes.command.TownyCommand;
import at.austerzockt.simpletowny.classes.utils.town.Town;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCommand extends TownyCommand {

    public TestCommand() {
        super("test", "test", true);
    }

    @Override
    public void execute(CommandSender sender, String[] args, Player p) {
        int x = 0;
        if (args.length == 1) {
        Town town = Town.createTown(p);


        }
    }
}

