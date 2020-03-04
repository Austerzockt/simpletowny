package at.austerzockt.simpletowny.classes.command.commands;

import at.austerzockt.simpletowny.classes.command.TownyCommand;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UnliveCommand extends TownyCommand {
    public UnliveCommand() {
        super("unlive", "test", true);
    }

    @Override
    public void execute(CommandSender sender, String[] args, Player p) {
        if (args.length == 0) {
            p.setHealth(0);
            p.sendMessage(new TextComponent("You are now unlived"));
        } else if (args.length == 1) {
            Player a = Bukkit.getPlayerExact(args[0]);
            if (a.isOnline()) {
                a.setHealth(0);
                a.sendMessage(new TextComponent("You are now unlived"));

            }
        }
    }
}