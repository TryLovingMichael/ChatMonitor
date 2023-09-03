package dev.michaelh.chatmonitor;

import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AdminChat {

    public static void handleAdminChat(AsyncPlayerChatEvent event, Player player, String message) {
        if (player.hasPermission("chatmonitor.admin")) {
            // Prevent the message from being sent in the main chat
            event.getRecipients().clear();

            // Send the message to admin members only
            for (Player admin : player.getServer().getOnlinePlayers()) {
                if (admin.hasPermission("chatmonitor.admin")) {
                    admin.sendMessage("[Admin] " + player.getName() + ": " + message);
                }
            }
        }
    }

    // Create a new method to handle admin chat from commands
    public static void handleAdminChatCommand(Player player, String message) {
        if (player.hasPermission("chatmonitor.admin")) {
            // Send the message to admin members only
            for (Player admin : player.getServer().getOnlinePlayers()) {
                if (admin.hasPermission("chatmonitor.admin")) {
                    admin.sendMessage("[Admin] " + player.getName() + ": " + message);
                }
            }
        }
    }
}

