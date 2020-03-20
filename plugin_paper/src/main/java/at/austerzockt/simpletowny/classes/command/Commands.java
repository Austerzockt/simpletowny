package at.austerzockt.simpletowny.classes.command;

import at.austerzockt.simpletowny.classes.command.commands.GameModeCommand;
import at.austerzockt.simpletowny.classes.command.commands.TestCommand;
import at.austerzockt.simpletowny.classes.command.commands.UnliveCommand;
import at.austerzockt.simpletowny.classes.command.tabcompletions.GameModeTab;

public class Commands {
    public Commands() {
        new TestCommand(null);
        new UnliveCommand(null);
        new GameModeCommand(new GameModeTab());

    }
}
