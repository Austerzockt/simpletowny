package at.austerzockt.simpletowny.classes.command.tabcompletions;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class GameModeTab implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> list = new ArrayList<>();
        if (command.getName().equalsIgnoreCase("gamemode")) {
            list.add("1");
            list.add("creative");
            list.add("0");
            list.add("survival");
            list.add("2");
            list.add("adventure");
            list.add("3");
            list.add("spectator");
            if (list.contains(args[0])) {
                list.clear();
                for (Player p :
                        Bukkit.getOnlinePlayers()) {
                    list.add(p.getName());
                }
            }
        }
        return list;
    }
}
