package at.austerzockt.simpletowny.classes.townsystem;

import org.bukkit.Chunk;

import java.util.ArrayList;

public class Town {
    private ArrayList<Chunk> area = new ArrayList<>();
    private Nation nation;
    public boolean hasNation;

    public Town(ArrayList<Chunk> area, Nation nation) {
        this.area = area;
        if (nation != null) {
            this.nation = nation;
            hasNation = true;
        } else {
            this.hasNation = false;
        }

    }

    public Town(ArrayList<Chunk> area) {
        this.area = area;
        this.nation = null;
        this.hasNation = false;
    }
}
