package at.austerzockt.simpletowny.classes.utils.town;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class TownListener implements Listener {
    public void onEnter(PlayerMoveEvent e) {
        e.getPlayer().sendMessage(String.valueOf(e.getFrom().getChunk().getX()));
    }
}
