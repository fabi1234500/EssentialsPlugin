package essentials.fabidev.main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable(){
        System.out.println("Das EssentialsPlugin wurde erfolgreich geladen!");
    }

    @Override
    public void onDisable(){
        System.out.println("Das EssentialsPlugin wurde erfolgreich beendet!");
    }

}
