
package net.arcanerealm.arenasigns;

import java.util.ArrayList;
import net.arcanerealm.arenasigns.framework.ArenaSign;
import net.vectorgaming.vcore.framework.VertexAPI;
import net.vectorgaming.vcore.framework.VertexPlugin;
import org.bukkit.Location;
import org.bukkit.block.Block;

/**
 *
 * @author Kenny
 */
public class ArenaSignsAPI extends VertexAPI
{
    private static final ArrayList<ArenaSign> signs = new ArrayList<>();
    
    public ArenaSignsAPI(VertexPlugin plugin)
    {
        super(plugin);
    }
    
    /**
     * Creates an ArenaSign
     * @param block The block to create the sign on
     * @param map The map the sign will show
     * @param arena The arena the sign will show
     */
    public static void createSign(Block block, String map, String arena)
    {
        signs.add(new ArenaSign(block.getLocation(), map, arena));
    }
    
    /**
     * Creates an ArenaSign
     * @param loc The location to create the sign on
     * @param map The map the sign will show
     * @param arena The arena the sign will show
     */
    public static void createSign(Location loc, String map, String arena)
    {
        createSign(loc.getBlock(), map, arena);
    }
    
    /**
     * Deletes an arena sign from the given location
     * @param loc Location of the sign
     */
    public static void deleteSign(Location loc)
    {
        getAllSigns().remove(getSignAtLocation(loc));
    }
    
    public static ArenaSign getSignAtLocation(Location loc)
    {
        for(ArenaSign sign : getAllSigns())
        {
            if(sign.getLocation().equals(loc))
            {
                return sign;
            }
        }
        return null;
    }
    
    /**
     * Returns a list of all the ArenaSigns created
     * @return List of ArenaSigns
     */
    public static ArrayList<ArenaSign> getAllSigns()
    {
        return signs;
    }
    
    /**
     * Gets a list of all the signs that are registered for an arena
     * @param arena Arena name
     * @return List of ArenaSigns
     */
    public static ArrayList<ArenaSign> getSignsForArena(String arena)
    {
        ArrayList<ArenaSign> result = new ArrayList<>();
        for(ArenaSign sign : signs)
        {
            if(sign.getArenaName().equalsIgnoreCase(arena))
            {
                result.add(sign);
            }
        }
        return result;
    }
    
    /**
     * Updates all the ArenaSigns that have been created
     */
    public static void updateAllSigns()
    {
        for(ArenaSign sign : getAllSigns())
        {
            sign.update();
        }
    }
    
    /**
     * Updates all the ArenaSigns registered for the given arena
     * @param arena Name of the arena
     */
    public static void updateAllArenaSigns(String arena)
    {
        for(ArenaSign sign : getSignsForArena(arena))
        {
            sign.update();
        }
    }
    
    public static boolean isSignAtLocation(Location loc)
    {
        for(ArenaSign sign : getAllSigns())
        {
            if(sign.getLocation().equals(loc))
            {
                return true;
            }
        }
        return false;
    }
}
