package at.austerzockt.simpletowny.classes.command;

import at.austerzockt.simpletowny.classes.command.commands.TestCommand;

import java.util.ArrayList;

public class Commands {
    private ArrayList<TownyCommand> list = new ArrayList();
    public Commands() {
        list.add(new TestCommand());
    }
}
