package at.austerzockt.simpletowny.classes.utils;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import org.bukkit.entity.Player;

public class LuckPermsIntegration {

    private LuckPerms luckPerms;

    public LuckPermsIntegration() {
        luckPerms = LuckPermsProvider.get();

    }

    public LuckPerms getAPI() {
        return luckPerms;
    }

    public String getPrimaryGroup(Player p) {
        return luckPerms.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup();
    }
}
