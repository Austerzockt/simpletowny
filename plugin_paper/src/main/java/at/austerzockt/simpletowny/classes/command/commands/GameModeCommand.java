package at.austerzockt.simpletowny.classes.command.commands;

import at.austerzockt.simpletowny.classes.command.TownyCommand;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

public class GameModeCommand extends TownyCommand {
    public GameModeCommand(TabCompleter tabCompleter) {
        super("gamemode", "gamemode", true, tabCompleter);
    }

    @Override
    public void execute(CommandSender sender, String[] args, Player p) {
        if (args.length == 1) {
            GameMode gameMode = parse(args, p);
            if (gameMode == null) {
                p.sendMessage(new TextComponent(ChatColor.GOLD + "Gamemode not recognized"));
            } else {
                p.setGameMode(gameMode);
                p.sendMessage(ChatColor.GOLD + "Set your Gamemode to " + gameMode.toString());

            }

        } else if (args.length == 2) {
            Player a = Bukkit.getPlayer(args[1]);

            GameMode gameMode = parse(args, p);
            if (gameMode != null) {
                if (a != null) {
                    if (!a.hasPermission("Server.gamemode.ignore")) {
                        a.setGameMode(gameMode);
                        p.sendMessage(ChatColor.GOLD + "Set your Gamemode to " + gameMode.toString());
                    } else {
                        p.sendMessage(new TextComponent(ChatColor.RED + "You can't set this players Gamemode"));
                    }
                } else {
                    p.sendMessage(new TextComponent(ChatColor.RED + "Unknown Player"));
                }

            } else {
                p.sendMessage(new TextComponent(ChatColor.RED + "Gamemode not recognized"));


            }

        }

    }

    private GameMode parse(String[] args, Player p) {
        switch (args[0]) {
            case "1":

            case "creative":
                if (p.hasPermission("Server.gamemode.creative"))
                    return GameMode.CREATIVE;

                break;
            case "survival":
            case "0":
                if (p.hasPermission("Server.gamemode.survival"))
                    return GameMode.SURVIVAL;

                break;
            case "spectator":
            case "3":
                if (p.hasPermission("Server.gamemode.spectator"))
                    return GameMode.SPECTATOR;

                break;
            case "2":
            case "adventure":
                if (p.hasPermission("Server.gamemode.adventure"))
                    return GameMode.ADVENTURE;

                break;
        }
        return null;


    }
}
