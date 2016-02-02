package org.spigotmc.tutorial;

import com.google.common.collect.Lists;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

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

    private static double distanceSquared(Vector from, Vector to)
    {
        double dx = to.getBlockX() - from.getBlockX();
        double dz = to.getBlockZ() - from.getBlockZ();

        return dx * dx + dz * dz;
    }

    public static Vector calculateVelocity(Vector from, Vector to, int heightGain)
    {
        // Gravity of a potion
        double gravity = 0.115;

        // Block locations
        int endGain = to.getBlockY() - from.getBlockY();
        double horizDist = Math.sqrt(distanceSquared(from, to));

        // Height gain
        int gain = heightGain;

        double maxGain = gain > (endGain + gain) ? gain : (endGain + gain);

        // Solve quadratic equation for velocity
        double a = -horizDist * horizDist / (4 * maxGain);
        double b = horizDist;
        double c = -endGain;

        double slope = -b / (2 * a) - Math.sqrt(b * b - 4 * a * c) / (2 * a);

        // Vertical velocity
        double vy = Math.sqrt(maxGain * gravity);

        // Horizontal velocity
        double vh = vy / slope;

        // Calculate horizontal direction
        int dx = to.getBlockX() - from.getBlockX();
        int dz = to.getBlockZ() - from.getBlockZ();
        double mag = Math.sqrt(dx * dx + dz * dz);
        double dirx = dx / mag;
        double dirz = dz / mag;

        // Horizontal velocity components
        double vx = vh * dirx;
        double vz = vh * dirz;

        return new Vector(vx, vy, vz);
    }


    @EventHandler
    public void toggle(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        double radiusSquared = 100*100;


        if (player.getInventory().getItemInHand().getType() == Material.STICK) {
            if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                List<Entity> entities = player.getNearbyEntities(20, 20, 20);

                for (Entity entity : entities) {

                    if(entity.getLocation().distanceSquared(player.getLocation()) > radiusSquared) continue; // All entities within a sphere


                    if(entity instanceof Player){

                        /*get the full inventory from the entity*/


//                        for(ItemStack itemStack : ((Player) entity).getInventory()){
//                            if(itemStack == null){
//                                break;
//                            }
//                            World world = entity.getWorld();
//                            Item throwable = world.dropItem(entity.getLocation(), itemStack);
//                            Vector velocity = calculateVelocity(throwable.getLocation().toVector(), player.getLocation().toVector(), 5);
//                            throwable.setVelocity(velocity);
//                            ((Player) entity).getInventory().remove(itemStack);
//
//                        }


                            /*only the item that is in the hand from the entity*/
                        World world = entity.getWorld();
                        ItemStack inHandItem = ((Player) entity).getItemInHand();
                        Item throwable = world.dropItem(entity.getLocation(), inHandItem);
                        Vector velocity = calculateVelocity(throwable.getLocation().toVector(), player.getLocation().toVector(), 5);
                        throwable.setVelocity(velocity);
                        ((Player) entity).getInventory().remove(inHandItem);

                        player.sendMessage(ChatColor.RED + "players there. "+ ((Player) entity).getName());
                    }

                }
            }

        }
    }

}
