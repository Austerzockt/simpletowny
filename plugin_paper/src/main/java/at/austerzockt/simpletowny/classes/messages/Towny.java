package at.austerzockt.simpletowny.classes.messages;

import net.md_5.bungee.api.chat.TextComponent;

public class Towny {
    private Towny() {}

    public TextComponent test = new TextComponent();

    public static Towny create() {
        Towny towny = new Towny();
        towny.test.setText("Well yes");

        return towny;
    }
}
