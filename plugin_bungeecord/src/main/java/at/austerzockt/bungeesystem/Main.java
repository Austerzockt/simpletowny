package at.austerzockt.bungeesystem;

import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class Main extends net.md_5.bungee.api.plugin.Plugin implements Listener {
    @Override
    public void onEnable() {
        this.getProxy().broadcast(new TextComponent("lol"));
        this.getProxy().getPluginManager().registerCommand(this, new Test());
        getProxy().getPluginManager().registerListener(this, this);


    }

    @EventHandler
    public void onJoin(PostLoginEvent e) {
        if (e.getPlayer() != null)
            this.getProxy().broadcast(new TextComponent("foo"));
    }
}
