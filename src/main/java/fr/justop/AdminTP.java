package fr.justop;

import fr.justop.commands.SpawnCommand;
import fr.justop.commands.TpCommand;
import fr.justop.listeners.InventoryPlayer;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.net.InetSocketAddress;

public class AdminTP extends JavaPlugin
{
    public static String PREFIX = "§c[§aHycraft-AdminTP§c] §r";

    @Override
    public void onEnable() {

        Bukkit.getServer().getConsoleSender().sendMessage(PREFIX + "§aLe plugin vient de s'allumer");
        onCommands();
        onListeners();
    }

    private void onListeners()
    {
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new InventoryPlayer(), this);
    }

    private void onCommands()
    {
        this.getCommand("tpe").setExecutor(new TpCommand());
        this.getCommand("spawn").setExecutor(new SpawnCommand());
    }

    @Override
    public void onDisable() {

        Bukkit.getServer().getConsoleSender().sendMessage(PREFIX + "§cLe plugin vient de s'éteindre");

    }
}
