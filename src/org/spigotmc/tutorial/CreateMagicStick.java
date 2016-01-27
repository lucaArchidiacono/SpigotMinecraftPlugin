package org.spigotmc.tutorial;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CreateMagicStick implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            ItemStack magicStick = new ItemStack(Material.STICK, 1);

            player.getInventory().addItem(magicStick);
        }
        return true;
    }

}
