package dev.michaelh.chatmonitor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ReloadConfig implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        Player player = (Player) sender;

        if(!player.hasPermission("chatmonitor.reload")) {
            player.sendMessage("You do not have permission to use this command!");
            return true;
        } else {
            player.sendMessage("Reloading config...");
        }

        ChatMonitor.getPlugin(ChatMonitor.class).reloadConfig();

        return true;
    }


}
