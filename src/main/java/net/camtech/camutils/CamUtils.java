package net.camtech.camutils;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class CamUtils extends JavaPlugin
{

    public static JavaPlugin plugin;
    public static List<String> exploded = new ArrayList<String>();

    @Override
    public void onEnable()
    {
        plugin = this;
        PluginDescriptionFile pdf = this.getDescription();
        getLogger().info(ChatColor.BLUE + pdf.getName() + " v. " + pdf.getVersion() + " by " + pdf.getAuthors() + " has been enabled!");
        new CUtils_Listeners();
    }

    @Override
    public void onDisable()
    {
        PluginDescriptionFile pdf = this.getDescription();
        getLogger().info(ChatColor.RED + pdf.getName() + " has been disabled!");
    }
    
    public void checkTime()
    {
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                for(World world : Bukkit.getWorlds())
                {
                    Event event = new WorldTimeChangeEvent(world, world.getTime());
                    Bukkit.getPluginManager().callEvent(event);
                }
            }
        }.runTaskLater(this.plugin, 20L * 10L);
    }
}
