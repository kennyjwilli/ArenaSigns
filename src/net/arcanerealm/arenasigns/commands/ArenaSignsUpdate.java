
package net.arcanerealm.arenasigns.commands;

import net.arcanerealm.arenasigns.ArenaSignsAPI;
import net.vectorgaming.vcore.framework.commands.SubCommand;
import org.bukkit.command.CommandSender;

/**
 *
 * @author Kenny
 */
public class ArenaSignsUpdate extends SubCommand
{
    public ArenaSignsUpdate()
    {
        super("update", ArenaSignsAPI.getPlugin());
    }
    
    @Override
    public void run(CommandSender cs, String[] args)
    {
        if(args.length == 1)
        {
            ArenaSignsAPI.updateAllArenaSigns(args[0]);
            cs.sendMessage("Done");
            return;
        }
        ArenaSignsAPI.updateAllSigns();
    }

    @Override
    public String getDescription()
    {
        return "Updates all ArenaSigns";
    }

    @Override
    public String getUsage()
    {
        return "/arenasigns update";
    }

    @Override
    public String getPermission()
    {
        return "arenasigns.update";
    }

    @Override
    public Integer getMinArgsLength()
    {
        return 0;
    }

    @Override
    public Integer getMaxArgsLength()
    {
        return 1;
    }

    @Override
    public boolean isPlayerOnlyCommand()
    {
        return false;
    }

}
