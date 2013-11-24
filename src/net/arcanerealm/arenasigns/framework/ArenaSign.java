
package net.arcanerealm.arenasigns.framework;

import net.vectorgaming.varenas.ArenaManager;
import net.vectorgaming.varenas.ArenaPlayerManager;
import net.vectorgaming.varenas.framework.Arena;
import org.apache.commons.lang3.text.WordUtils;
import org.bukkit.ChatColor;
import org.bukkit.block.Sign;

/**
 *
 * @author Kenny
 */
public class ArenaSign extends SignWrapper
{
    private final String arenaName;
    private final String map;
    
    /**
     *
     * @param sign Sign to inherit traits from
     * @param map Map the sign is based off
     * @param arena Arena the sign is based off
     */
    public ArenaSign(Sign sign, String map, String arena)
    {
        super(sign);
        this.map = map;
        this.arenaName = arena;
        updateSign();
    }
    
    /**
     * Updates the sign to all the latest values from the arena
     */
    public final void updateSign()
    {
        this.setLine(0, ChatColor.BOLD+ArenaManager.getArenaSettings(map).getType());
        
        this.setLine(2, arenaName.split("_")[1]);
        if(!ArenaManager.isArenaRunning(arenaName))
        {
            this.setLine(1, ChatColor.RED+WordUtils.capitalize(map));
            this.setLine(3, "");
        }else
        {
            this.setLine(1, ChatColor.GREEN+WordUtils.capitalize(map));
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
            this.setLine(3, playersInArena+"/"+maxPlayers);
        }
        update();
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
}
