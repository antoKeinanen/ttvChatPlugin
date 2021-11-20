package me.jm.ttvchat.ttvchat;

import me.jm.ttvchat.ttvchat.commands.ListEmotesCMD;
import me.jm.ttvchat.ttvchat.listeners.PlayerChatListener;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;

public final class TtvChat extends JavaPlugin {

    @Override
    public void onEnable() {
        //register events
        PlayerChatListener playerChatListener = new PlayerChatListener();
        getServer().getPluginManager().registerEvents(playerChatListener, this);

        getServer().getPluginManager().addPermission(new Permission("ttvChat.useEmotes", "Allows users to use emotes."));

        //register commands
        ListEmotesCMD listEmotesCMD = new ListEmotesCMD();
        this.getCommand("listEmotes").setExecutor(listEmotesCMD);
    }

    @Override
    public void onDisable() {

    }
}
