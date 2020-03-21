package at.austerzockt.simpletowny.classes.utils;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.group.GroupManager;
import net.luckperms.api.model.user.UserManager;
import org.bukkit.entity.Player;

public class LuckPermsIntegration {

    public LuckPerms luckPerms;

    public LuckPermsIntegration() {
        luckPerms = LuckPermsProvider.get();

    }

    public String getPrimaryGroup(Player p) {
        return luckPerms.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup();
    }

    public UserManager getUserManager() {
        return luckPerms.getUserManager();
    }

    public GroupManager getGroupManager() {
        return luckPerms.getGroupManager();
    }
}
