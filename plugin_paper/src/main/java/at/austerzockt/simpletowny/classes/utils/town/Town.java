package at.austerzockt.simpletowny.classes.utils.town;

import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Town {
    //TODO: Database Integration
    private Player mayor;
    private ArrayList<Vector2> area;
    private Town(Player founder) {
        mayor = founder;
        area = new ArrayList<>();
        area.add(Vector2.fromChunk(founder.getChunk()));
        mayor.sendMessage(new TextComponent(area.toString()));

    }
    public static Town createTown(Player founder) {
        return new Town(founder);
    }






}
