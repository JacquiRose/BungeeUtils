package solar.rpg.utils;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.logging.Level;

/**
 * Messages all online staff.
 */
public class AdminChatCommand extends SkyCommand {

    AdminChatCommand(Main plugin) {
        super(plugin, "adminchat", "skytopia.staff", "ac");
    }

    @Override
    public void execute(CommandSender sender, String[] strings) {
        if (!validateArgs(sender, strings, 1, -1)) return;
        String message = implode(strings);
        String name = sender instanceof ProxiedPlayer ? ((ProxiedPlayer) sender).getDisplayName() : sender.getName();
        String server = !(sender instanceof ProxiedPlayer) ? "?" : ((ProxiedPlayer) sender).getServer().getInfo().getName();
        for (ProxiedPlayer player : plugin.getProxy().getPlayers())
            if (isStaff(player))
                player.sendMessage(ChatColor.GRAY + "[" + server + "] <" + ChatColor.RED + name + ChatColor.GRAY + "> " + message);
        plugin.getLogger().log(Level.INFO, "[" + server + "] <" + name + "> " + message);
    }

    private String implode(String[] args) {
        StringBuilder result = new StringBuilder();
        for (String arg : args)
            result.append(arg).append(" ");
        return result.toString().trim();
    }
}
