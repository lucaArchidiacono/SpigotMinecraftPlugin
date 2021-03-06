package org.spigotmc.tutorial;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ItemStackUpgrade implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            ItemStack potato = new ItemStack(Material.BAKED_POTATO);
            ItemStack diamondSword = new ItemStack(Material.DIAMOND_SWORD);

            diamondSword.setAmount(7);
            potato.setAmount(10);

            player.getInventory().addItem(diamondSword, potato);

        }

        return true;
    }


}


