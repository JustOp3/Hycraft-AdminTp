package fr.justop.commands;

import fr.justop.AdminTP;
import fr.justop.listeners.InventoryPlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class TpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(! (sender instanceof Player)) return false;

        Player player = (Player) sender;

        if(!player.isOp())
        {
            player.sendMessage(AdminTP.PREFIX + "§cVous n'avez pas la permission d'executer cette commande");
        }

        if(command.getName().equalsIgnoreCase("Tpe"))
        {
            if(args.length == 0)
            {
                InventoryPlayer inventoryPlayer = new InventoryPlayer();
                inventoryPlayer.buildItems();
                inventoryPlayer.openInventory(player);
                return true;
            }
        }

        return false;


    }
}
