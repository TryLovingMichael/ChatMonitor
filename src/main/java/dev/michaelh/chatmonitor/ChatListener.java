package dev.michaelh.chatmonitor;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    private final ChatMonitor plugin;

    public ChatListener(ChatMonitor plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();

        // Apply autocorrection
        message = applyAutoCorrection(message);

        // Check for and censor swear words
        message = censorSwearWords(message);

        event.setMessage(message);
    }

    private String applyAutoCorrection(String message) {
        // Implement your autocorrection logic here based on the configuration
        // For simplicity, let's assume you have a YAML config node 'auto_correct' with mappings of corrections
        for (String key : plugin.getConfig().getConfigurationSection("auto_correct").getKeys(false)) {
            String correction = plugin.getConfig().getString("auto_correct." + key);
            message = message.replaceAll(key, correction);
        }
        return message;
    }

    private String censorSwearWords(String message) {
        // Implement your anti-swear logic here based on the configuration
        // For simplicity, let's assume you have a list of banned words in YAML under 'banned_words'
        for (String bannedWord : plugin.getConfig().getStringList("banned_words")) {
            message = message.replaceAll(bannedWord, "****");
        }
        return message;
    }
}
