package org.spigotmc.tutorial;

import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.logging.Logger;

public class Main extends JavaPlugin implements CommandExecutor{

    Main main = this;

    HashMap<Player, String> numberPlayers;

    public Main(){

        this.numberPlayers = new HashMap();

    }


    @Override
    public void onEnable(){
        //Fired when the server enables the plugin
        getServer().getPluginManager().registerEvents(new PlayerListenerForMagicStick(this.main), this);
        this.getCommand("dragon").setExecutor(new DragonCommand());
        this.getCommand("swordandpotato").setExecutor(new ItemStackUpgrade());
        this.getCommand("createmagicstick").setExecutor(new CreateMagicStick());
        PluginDescriptionFile pdfFile = getDescription();
        Logger logger = Logger.getLogger("Minecraft");

        logger.info(pdfFile.getName() + " has been enabled (V." + pdfFile.getVersion() +")");
    }

    @Override
    public void onDisable(){
        //Fired when the server stops and disables all plugins
        PluginDescriptionFile pdfFile = getDescription();
        Logger logger = Logger.getLogger("Minecraft");

        logger.info(pdfFile.getName() + " has been disabled (V." + pdfFile.getVersion() +")");

    }

}