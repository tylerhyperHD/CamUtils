package net.camtech.camutils;

import java.util.Random;
import static net.camtech.camutils.CamUtils.plugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class CUtils_Listeners implements Listener
{

    static Random random = new Random();

    public CUtils_Listeners()
    {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public static void onPlayerDeath(PlayerDeathEvent event)
    {
        if(CamUtils.exploded.contains(event.getEntity().getName()))
        {
            event.setDeathMessage(event.getEntity().getName() + randomDeathMessage());
            CamUtils.exploded.remove(event.getEntity().getName());
        }
    }

    private static String randomDeathMessage()
    {
        int i = random.nextInt(5);
        if(i == 1)
        {
            return " turned into a spray!";
        }
        if(i == 2)
        {
            return " was splattered across the walls!";
        }
        if(i == 3)
        {
            return " exploded!";
        } else
        {
            return " blew up!";
        }
    }
}
