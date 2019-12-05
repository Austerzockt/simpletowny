package at.austerzockt.simpletowny.classes.command.commands;

import at.austerzockt.simpletowny.classes.command.TownyCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCommand extends TownyCommand {

    public TestCommand() {
        super("test", "test", true);
    }

    @Override
    public void execute(CommandSender sender, String[] args, Player p) {
        if (args.length == 1) {


        }
    }
}
