package at.austerzockt.simpletowny.classes.command.commands;

import at.austerzockt.simpletowny.classes.Towny;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;



public abstract class TownyCommand implements CommandExecutor {
    private final String commandName;
    private final String permission;

    protected TownyCommand(String commandname, String permission) {
        this.commandName = commandname;
        this.permission = "Server." + permission;
        Objects.requireNonNull(Towny.INSTANCE.getCommand(commandname)).setExecutor(this);


    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
        if (commandName.equalsIgnoreCase(commandName)) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (p.hasPermission(permission)) {

                    execute(sender, args, p);  //Execute the command

                } else {
                    sender.sendMessage(ChatColor.RED + "No permission!");

                }
            } else {
                sender.sendMessage(ChatColor.RED + "You are not a player!");

            }
        }
        return true;


    }

    public abstract void execute(CommandSender sender, String[] args, Player p);
}
