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
            ItemStack diamondAxe = new ItemStack(Material.DIAMOND_AXE);
            ItemStack diamondSword = new ItemStack(Material.DIAMOND_SWORD);
            ItemStack diamondHoe = new ItemStack(Material.DIAMOND_HOE);
            ItemStack diamondLeggings = new ItemStack(Material.DIAMOND_LEGGINGS);
            ItemStack diamondSpade = new ItemStack(Material.DIAMOND_SPADE);

            diamondSpade.setAmount(6);
            diamondSword.setAmount(7);
            diamondLeggings.setAmount(8);
            diamondHoe.setAmount(9);
            diamondAxe.setAmount(10);
            potato.setAmount(10);

            player.getInventory().addItem(diamondAxe, diamondHoe, diamondSword, diamondLeggings, potato, diamondSpade);

        }

        return true;
    }


}


