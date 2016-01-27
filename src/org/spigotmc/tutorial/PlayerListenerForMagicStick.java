package org.spigotmc.tutorial;

import com.google.common.collect.Lists;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Collections;
import java.util.List;

public class PlayerListenerForMagicStick implements Listener {

    Main main;
    public int counter;

    public PlayerListenerForMagicStick(Main instance) {
        this.main = instance;
    }

    public static List<Player> getOnlinePlayers() {
        List<Player> list = Lists.newArrayList();
        for (World world : Bukkit.getWorlds()) {
            list.addAll(world.getPlayers());
        }
        return Collections.unmodifiableList(list);
    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
//        this.main.numberPlayers.put(player, player.getName());
        event.getPlayer().sendMessage("Ciao Brudi --> "+ player.getName());
        event.getPlayer().sendMessage("Diese Spieler sind in diesem Server drin: ");
        event.getPlayer().sendMessage(""+getOnlinePlayers());


//        for(counter=1; counter<=this.main.numberPlayers.size(); counter++){
//            event.getPlayer().sendMessage(""+this.main.numberPlayers);
//        }

    }

    @EventHandler
    public void toggle(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        double radiusSquared = 20*20;


        if (player.getInventory().getItemInHand().getType() == Material.STICK) {
            if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                List<Entity> entities = player.getNearbyEntities(20, 20, 20);

                for (Entity entity : entities) {

                    if(entity.getLocation().distanceSquared(player.getLocation()) > radiusSquared) continue; // All entities within a sphere

                    if(entity instanceof Player){

                        player.sendMessage(ChatColor.RED + "players there. "+ ((Player) entity).getName());
                    }

                }
            }

        }
    }

}
