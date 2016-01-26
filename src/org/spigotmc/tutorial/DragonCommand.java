package org.spigotmc.tutorial;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;


public class DragonCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            player.getWorld().spawnEntity(player.getLocation(), EntityType.ENDER_DRAGON);

//            ItemStack potato = new ItemStack(Material.BAKED_POTATO);
//            ItemStack axe = new ItemStack(Material.DIAMOND_AXE);
//            axe.setAmount(20);
//            potato.setAmount(30);
//            player.getInventory().addItem(potato, axe);

        }

        return true;
    }


}
