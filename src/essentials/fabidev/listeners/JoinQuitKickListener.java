package essentials.fabidev.listeners;

import essentials.fabidev.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.UUID;

public class JoinQuitKickListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        if(p.hasPermission("essentials.autovanish")){
            Main.vanish.add(p.getUniqueId());
            for(Player all : Bukkit.getOnlinePlayers()){
                all.hidePlayer(Main.pl, p);
            }
            p.sendMessage("§aDu bist nun für alle Spieler unsichtbar!");
        }

        if(!Main.vanish.isEmpty()) {
            for (UUID uuid : Main.vanish) {
                Player vanish = Bukkit.getPlayer(uuid);
                p.hidePlayer(Main.pl, vanish);
            }
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        Player p = e.getPlayer();
        if(Main.vanish.contains(p.getUniqueId())){
            Main.vanish.remove(p.getUniqueId());
        }
    }

    @EventHandler
    public void onKick(PlayerKickEvent e){
        Player p = e.getPlayer();
        if(Main.vanish.contains(p.getUniqueId())){
            Main.vanish.remove(p.getUniqueId());
        }
    }

}
