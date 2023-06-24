package fr.justop.commands;

import fr.justop.AdminTP;
import fr.justop.listeners.InventoryPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(! (sender instanceof Player)) return false;

        Player player = (Player) sender;

        if(command.getName().equalsIgnoreCase("spawn"))
        {
            if(args.length == 0)
            {
                player.teleport(new Location(Bukkit.getWorld("Lobby_Japon"), -2.0, 160.0, 0.0, 90.0f, 0.0f));
                player.sendMessage(AdminTP.PREFIX + "§e Vous avez été téléporté au spawwn.");
                return true;
            }
        }

        return false;
    }
}
