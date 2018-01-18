package solar.rpg.utils;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

abstract class SkyCommand extends Command {

    final Main plugin;
    private final String[] STAFF_NAMES = {"ILavaYou", "JacquiRose", "LiterallyMac", "Willard21"};

    SkyCommand(Main plugin, String name, String permission, String... aliases) {
        super(name, permission, aliases);
        this.plugin = plugin;
        plugin.getProxy().getPluginManager().registerCommand(plugin, this);
    }

    boolean validateArgs(CommandSender sender, String[] args, int min, int max) {
        if (args.length < min) {
            sender.sendMessage(ChatColor.RED + "Too few arguments. Try again.");
            return false;
        }
        if (max != -1 && args.length > max) {
            sender.sendMessage(ChatColor.RED + "Too many arguments. try again.");
            return false;
        }
        return true;
    }

    boolean isStaff(ProxiedPlayer player) {
        for (String staff : STAFF_NAMES)
            if (player.getName().equals(staff))
                return true;
        return player.hasPermission("skytopia.staff");
    }
}
