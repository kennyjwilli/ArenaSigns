
package net.arcanerealm.arenasigns.commands;

import java.util.HashMap;
import net.arcanerealm.arenasigns.ArenaSignsAPI;
import net.vectorgaming.varenas.ArenaManager;
import net.vectorgaming.vcore.framework.commands.SubCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 *
 * @author Kenny
 */
public class ArenaSignsCreate extends SubCommand
{
    private static final HashMap<Player, String> signCreators = new HashMap<>();
    
    public ArenaSignsCreate()
    {
        super("create", ArenaSignsAPI.getPlugin());
    }
    
    @Override
    public void run(CommandSender cs, String[] args)
    {
        if(!ArenaManager.mapExists(args[0].toLowerCase()))
        {
            cs.sendMessage(ChatColor.RED+"Error: Map "+ChatColor.YELLOW+args[1]+ChatColor.RED+" does not exist.");
            return;
        }
        
        enableSignCreation((Player) cs, args[0], args[1]);
        cs.sendMessage(ChatColor.GREEN+"Right click the block where the sign will be created.");
    }

    @Override
    public String getDescription()
    {
        return "Creates an arena sign";
    }

    @Override
    public String getUsage()
    {
        return "/arenasigns create <map> <arena>";
    }

    @Override
    public String getPermission()
    {
        return "arenasigns.create";
    }

    @Override
    public Integer getMinArgsLength()
    {
        return 2;
    }

    @Override
    public Integer getMaxArgsLength()
    {
        return 2;
    }

    @Override
    public boolean isPlayerOnlyCommand()
    {
        return true;
    }
    
    public static boolean canCreateSign(Player p)
    {
        return signCreators.containsKey(p);
    }
    
    public static void enableSignCreation(Player p, String map, String arena)
    {
        signCreators.put(p, map+","+arena);
    }
    
    public static void disableSignCreation(Player p)
    {
        signCreators.remove(p);
    }
    
    public static String getMapFromCreator(Player p)
    {
        return signCreators.get(p).split(",")[0];
    }
    
    public static String getArenaFromCreator(Player p)
    {
        return signCreators.get(p).split(",")[1];
    }

}
