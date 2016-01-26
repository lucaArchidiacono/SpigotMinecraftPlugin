package org.spigotmc.tutorial;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Main extends JavaPlugin implements CommandExecutor{


    @Override
    public void onEnable(){
        //Fired when the server enables the plugin
        this.getCommand("dragon").setExecutor(new DragonCommand());
        this.getCommand("itemstackupgrade").setExecutor(new ItemStackUpgrade());
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