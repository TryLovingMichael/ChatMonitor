package dev.michaelh.chatmonitor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("staffchat")) {
                if (args.length > 0) {
                    StringBuilder message = new StringBuilder();
                    for (String arg : args) {
                        message.append(arg).append(" ");
                    }
                    StaffChat.handleStaffChatCommand(player, message.toString());
                } else {
                    player.sendMessage("Usage: /staffchat [message]");
                }
            } else if (cmd.getName().equalsIgnoreCase("adminchat")) {
                if (args.length > 0) {
                    StringBuilder message = new StringBuilder();
                    for (String arg : args) {
                        message.append(arg).append(" ");
                    }
                    AdminChat.handleAdminChatCommand(player, message.toString());
                } else {
                    player.sendMessage("Usage: /adminchat [message]");
                }
            }
        } else {
            sender.sendMessage("Only players can use this command.");
        }
        return true;
    }
}

