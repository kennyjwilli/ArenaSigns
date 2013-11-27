
package net.arcanerealm.arenasigns.framework;

import net.arcanerealm.arenasigns.ArenaSignsAPI;
import net.vectorgaming.varenas.ArenaManager;
import net.vectorgaming.varenas.ArenaPlayerManager;
import net.vectorgaming.varenas.framework.Arena;
import org.apache.commons.lang3.text.WordUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Sign;

/**
 *
 * @author Kenny
 */
public class ArenaSign
{
    private final String arenaName;
    private final String map;
    private final Location loc;
    
    /**
     *
     * @param sign Sign to inherit traits from
     * @param map Map the sign is based off
     * @param arena Arena the sign is based off
     */
    public ArenaSign(Sign sign, String map, String arena)
    {
        this.loc = sign.getLocation();
        this.map = map;
        this.arenaName = arena;
    }
    
    /**
     *
     * @param location Location of the sign
     * @param map Map the sign is based off
     * @param arena Arena the sign is based off
     */
    public ArenaSign(Location location, String map, String arena)
    {
        this.loc = location;
        this.map = map;
        this.arenaName = arena;
    }
    
    public Location getLocation()
    {
        return loc;
    }
    
    /**
     * Gets the name of the arena the sign is based off
     * @return Name of the arena
     */
    public String getArenaName()
    {
        return arenaName;
    }
    
    /**
     * Gets the name of the map the sign is based off
     * @return Name of the map
     */
    public String getMap()
    {
        return map;
    }
    
    public void update()
    {
        loc.getChunk().load();
        final Sign sign = (Sign) loc.getBlock().getState();
        
        sign.setLine(0, ChatColor.BOLD+ArenaManager.getArenaSettings(map).getType());
        sign.setLine(2, arenaName.split("_")[1]);
        
        if(!ArenaManager.isArenaRunning(arenaName))
        {
            sign.setLine(1, ChatColor.RED+WordUtils.capitalize(map));
            sign.setLine(3, "");
        }else
        {
            sign.setLine(1, ChatColor.GREEN+WordUtils.capitalize(map));
            Arena arena = ArenaManager.getArena(arenaName);
            int playersInArena;
            if(ArenaPlayerManager.getPlayersInArena(arenaName) == null)
            {
                playersInArena = 0;
            }else
            {
                playersInArena = ArenaPlayerManager.getPlayersInArena(arenaName).size();
            }
            int maxPlayers = arena.getSettings().getMaxPlayers();
            sign.setLine(3, playersInArena+"/"+maxPlayers);
        }
        
        Bukkit.getScheduler().scheduleSyncDelayedTask(ArenaSignsAPI.getPlugin(), new Runnable()
        {
            @Override
            public void run()
            {
                sign.update(true);
            }
        }, 1L);
    }
}
