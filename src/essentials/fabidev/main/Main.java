package essentials.fabidev.main;

import essentials.fabidev.commands.VanishCommand;
import essentials.fabidev.listeners.JoinQuitKickListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.UUID;

public class Main extends JavaPlugin {

    public static ArrayList<UUID> vanish = new ArrayList<UUID>();

    public static Main pl;

    @Override
    public void onEnable(){
        pl = this;
        this.getCommand("vanish").setExecutor(new VanishCommand());
        getServer().getPluginManager().registerEvents(new JoinQuitKickListener(), this);
        System.out.println("Das EssentialsPlugin wurde erfolgreich geladen!");
    }

    @Override
    public void onDisable(){
        System.out.println("Das EssentialsPlugin wurde erfolgreich beendet!");
    }

}
