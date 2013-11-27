
package net.arcanerealm.arenasigns.util;

import info.jeppes.ZoneCore.ZoneConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import net.arcanerealm.arcanelib.ArcaneTools;
import net.arcanerealm.arenasigns.ArenaSignsAPI;
import net.arcanerealm.arenasigns.framework.ArenaSign;

/**
 *
 * @author Kenny
 */
public class SLAPI 
{
    private static final ZoneConfig config = new ZoneConfig(ArenaSignsAPI.getPlugin(), new File(ArenaSignsAPI.getPlugin().getDataFolder()+File.separator+"signs.yml"));
    
    public static void saveAllSigns()
    {
        List<String> signs = new ArrayList<>();
        for(ArenaSign sign : ArenaSignsAPI.getAllSigns())
        {
            String path = sign.getMap()+"."+sign.getArenaName();
            signs.add(ArcaneTools.saveLocation(sign.getLocation()));
            config.set(path+".locations", signs);
        }
        config.save();
    }
    
    public static void loadAllSigns()
    {
        for(String map : config.getKeys(false))
        {
            for(String arena : config.getConfigurationSection(map).getKeys(false))
            {
                for(String loc : config.getStringList(map+"."+arena+".locations"))
                {
                    ArenaSignsAPI.createSign(ArcaneTools.getLocationFromSave(loc), map, arena);
                }
            }
        }
    }
}
