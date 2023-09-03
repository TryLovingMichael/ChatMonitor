package dev.michaelh.chatmonitor;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class StaffChat implements Listener {
        public static void handleStaffChat(AsyncPlayerChatEvent event, Player player, String message) {
            if (player.hasPermission("chatmonitor.staff")) {
                // Prevent the message from being sent in the main chat
                event.getRecipients().clear();

                // Send the message to staff members only
                for (Player staff : player.getServer().getOnlinePlayers()) {
                    if (staff.hasPermission("chatmonitor.staff")) {
                        staff.sendMessage("[Staff] " + player.getName() + ": " + message);
                    }
                }
            }
        }

    // Create a new method to handle staff chat from commands
    public static void handleStaffChatCommand(Player player, String message) {
        if (player.hasPermission("chatmonitor.staff")) {
            // Send the message to staff members only
            for (Player staff : player.getServer().getOnlinePlayers()) {
                if (staff.hasPermission("chatmonitor.staff")) {
                    staff.sendMessage("[Staff] " + player.getName() + ": " + message);
                }
            }
        }
    }

}

