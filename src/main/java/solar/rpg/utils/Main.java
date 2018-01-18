package solar.rpg.utils;

import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin {

    public void onEnable() {
        new AdminChatCommand(this);
    }
}
