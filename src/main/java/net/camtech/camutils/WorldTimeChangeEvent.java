package net.camtech.camutils;

import org.bukkit.World;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class WorldTimeChangeEvent extends Event
{
    
    private static final HandlerList handlers = new HandlerList();
    private World world;
    private long time;
    
    public WorldTimeChangeEvent(World world, long time)
    {
        this.world = world;
        this.time = time;
    }
    
    @Override
    public HandlerList getHandlers()
    {
        return handlers;
    }
    
    public HandlerList getHandlerList()
    {
        return handlers;
    }
    
    public World getWorld()
    {
        return this.world;
    }
    
    public long getTime()
    {
        return this.time;
    }
}
