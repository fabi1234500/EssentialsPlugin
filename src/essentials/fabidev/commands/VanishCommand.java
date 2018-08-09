package essentials.fabidev.commands;

import essentials.fabidev.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VanishCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("essentials.vanish")){
                if(Main.vanish.isEmpty()){
                    Main.vanish.add(p.getUniqueId());
                    for(Player all : Bukkit.getOnlinePlayers()){
                        all.hidePlayer(Main.pl, p);
                    }
                    p.sendMessage("§aDu bist nun für alle Spieler unsichtbar!");
                }else{
                    if(Main.vanish.contains(p.getUniqueId())){
                        Main.vanish.remove(p.getUniqueId());
                        for(Player all : Bukkit.getOnlinePlayers()){
                            all.showPlayer(Main.pl, p);
                        }
                        p.sendMessage("§aDu bist nun für alle Spieler sichtbar!");
                    }else{
                        Main.vanish.add(p.getUniqueId());
                        for(Player all : Bukkit.getOnlinePlayers()){
                            all.hidePlayer(Main.pl, p);
                        }
                        p.sendMessage("§aDu bist nun für alle Spieler unsichtbar!");
                    }
                }


            }else{
                p.sendMessage("§cFehler: §4Dazu hast du keine Rechte!");
            }


        }else{
            System.out.println("Dieser Befehl ist nicht fuer die Konsole gedacht!");
        }

        return false;
    }
}
