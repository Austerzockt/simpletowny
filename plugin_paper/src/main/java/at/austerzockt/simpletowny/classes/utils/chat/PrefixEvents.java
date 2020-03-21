package at.austerzockt.simpletowny.classes.utils.chat;

import at.austerzockt.simpletowny.classes.Towny;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;


public class PrefixEvents implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Prefix prefix = Towny.playerPrefixManager.parser.prefixes.get(Towny.luckPermsIntegration.getPrimaryGroup(event.getPlayer()));
        //event.setMessage();
        event.setFormat(prefix.prefix + event.getPlayer().getName() + "&f:" + prefix.messagecolor + event.getMessage());
        Player p = event.getPlayer();
        event.setFormat(ChatColor.translateAlternateColorCodes('&', event.getFormat()));
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Bukkit.getConsoleSender().sendMessage(new TextComponent("x"));
        Player p = event.getPlayer();
        String group = Towny.luckPermsIntegration.getPrimaryGroup(p);
        String prefix = ChatColor.translateAlternateColorCodes('&', Towny.playerPrefixManager.parser.prefixes.get(group.toLowerCase()).prefix);
        p.setDisplayName(prefix + p.getName());
        p.setPlayerListName(prefix + p.getName());

    }
}
