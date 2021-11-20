package me.jm.ttvchat.ttvchat.commands;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ListEmotesCMD implements CommandExecutor {

    final int pages = 1;
    final String emotes1 = "poggers,peepoHappy,monkaW,3Head,<3,KEKW,Sadge,OMEGALUL,monkaS,PepeHands";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if (args.length >= 1 && args[0].matches(String.format("[1-%s]", "" + pages))){
                String[] emotes =  emotes1.split(",");
                player.sendMessage(String.format("<- List Of Available Emotes [%s/%x]->", args[0], pages));
                for (int i = 0; i < emotes.length; i++) {
                    int id = 0xE000 + i;
                    char emoteFontId = (char)id;
                    player.sendMessage(String.format("- %s %c", emotes[i], emoteFontId));
                }
            }
            else if(args.length == 0){
                String[] emotes =  emotes1.split(",");
                player.sendMessage(String.format(ChatColor.translateAlternateColorCodes('&', "&b&l<-&f&r List Of Available Emotes [1/%x] &b&l->"), pages));
                for (int i = 0; i < emotes.length; i++) {
                    int id = 0xE000 + i;
                    char emoteFontId = (char)id;
                    player.sendMessage(String.format("- %s %c", emotes[i], emoteFontId));
                }
            }
            else{
                player.sendMessage("Incorrect usage of command: /listemotes [page]");
            }
            return true;
        }
        return false;
    }
}
