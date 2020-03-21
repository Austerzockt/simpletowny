package at.austerzockt.simpletowny.classes.townsystem;

import java.util.ArrayList;

public class TownManager {
    public ArrayList<Town> towns;

    public TownManager() {
        towns = new ArrayList<>();

    }

    public void addTown(Town town) {
        towns.add(town);
    }
}
