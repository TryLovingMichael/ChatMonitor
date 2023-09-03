package dev.michaelh.chatmonitor;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class ChatMonitor extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getCommand("staffchat").setExecutor(new ChatCommands());
        getCommand("adminchat").setExecutor(new ChatCommands());

        getConfig().options().copyDefaults(true);
        saveConfig();

        getServer().getPluginManager().registerEvents(new ChatListener(this), this);
        this.getCommand("reloadconfig").setExecutor(new ReloadConfig());


        getLogger().info("ChatMonitor enabled!");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        getLogger().info("ChatMonitor disabled!");
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage();

        // Handle Staff Chat and Admin Chat
        if (message.startsWith("#") && player.hasPermission("chatmonitor.staff")) {
            StaffChat.handleStaffChat(event, player, message.substring(1));
        } else if (message.startsWith("@") && player.hasPermission("chatmonitor.admin")) {
            AdminChat.handleAdminChat(event, player, message.substring(1));
        }

        event.setMessage(message);
    }
}
