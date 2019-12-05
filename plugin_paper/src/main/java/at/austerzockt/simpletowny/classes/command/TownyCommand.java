package at.austerzockt.simpletowny.classes.command;

import at.austerzockt.simpletowny.classes.Towny;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public abstract class TownyCommand implements CommandExecutor {
    private final String commandName;
    private final String permission;
    private final boolean op;

    protected TownyCommand(String commandname, String permission, boolean op) {
        this.commandName = commandname;
        this.permission = "Server." + permission;
        this.op = op;
        Towny.INSTANCE.getCommand(commandname).setExecutor(this);


    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
        if (cmd.getName().equalsIgnoreCase(this.commandName)) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (p.hasPermission(permission)) {

                    execute(sender, args, p);  //Execute the command

                } else if (op && p.isOp()) {
                    execute(sender, args, p);

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
