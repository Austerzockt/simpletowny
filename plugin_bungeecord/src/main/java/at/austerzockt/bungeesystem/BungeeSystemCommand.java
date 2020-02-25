package at.austerzockt.bungeesystem;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.connection.Server;
import net.md_5.bungee.api.plugin.Command;

public abstract class BungeeSystemCommand extends Command {
    public BungeeSystemCommand(String name, String permission, String... aliases) {
        super(name, permission, aliases);
    }

    public void execute(CommandSender commandSender, String[] strings) {
        if (commandSender.hasPermission(getPermission())) {
            if (commandSender instanceof ProxiedPlayer) {
                ProxiedPlayer player = (ProxiedPlayer) commandSender;
                Server server = player.getServer();
                execute(commandSender, player, strings, server);

            }
        }

    }

    public abstract void execute(CommandSender commandSender, ProxiedPlayer player, String[] args, Server server);
}
