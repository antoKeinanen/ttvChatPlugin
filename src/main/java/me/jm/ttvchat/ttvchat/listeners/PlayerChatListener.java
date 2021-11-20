package me.jm.ttvchat.ttvchat.listeners;

import com.google.common.escape.UnicodeEscaper;
import org.apache.commons.lang.StringEscapeUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChatListener implements Listener {

    final String emotes1 = "poggers,peepoHappy,monkaW,3Head,<3,KEKW,Sadge,OMEGALUL,monkaS,PepeHands";

    @EventHandler
    void AsyncPlayerChatEvent(AsyncPlayerChatEvent e){
       String msg = e.getMessage();
       String _msg = CheckForEmotes(msg);
       e.setMessage(_msg);
    }

    String CheckForEmotes(String msg){
        String[] _emotes1 = emotes1.split(",");
        for (int i = 0; i < _emotes1.length; i++) {
            if (msg.contains(_emotes1[i])){
                int id = 0xE000 + i;
                char emoteFontId = (char)id;
                msg = msg.replace(_emotes1[i], "" + emoteFontId);
            }
        }
        return msg;
    }
}
