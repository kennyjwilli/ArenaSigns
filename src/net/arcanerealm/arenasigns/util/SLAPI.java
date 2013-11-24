
package net.arcanerealm.arenasigns.util;

import info.jeppes.ZoneCore.ZoneConfig;
import java.io.File;
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
    
    public static void saveSign(ArenaSign sign)
    {
        String path = sign.getMap()+"."+sign.getArenaName();
        config.set(path+".location", ArcaneTools.saveLocation(sign.getLocation()));
    }
    
    public static void saveAllSigns()
    {
        for(ArenaSign sign : ArenaSignsAPI.getAllSigns())
        {
            saveSign(sign);
        }
        config.save();
    }
    
    public static void loadAllSigns()
    {
        for(String map : config.getKeys(false))
        {
            for(String arena : config.getConfigurationSection(map).getKeys(false))
            {
                ArenaSignsAPI.createSign(ArcaneTools.getLocationFromSave(config.getString(map+"."+arena+".location")), map, arena);
            }
        }
    }
}
