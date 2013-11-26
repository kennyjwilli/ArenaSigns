
package net.arcanerealm.arenasigns.commands;

import net.arcanerealm.arenasigns.ArenaSignsAPI;
import net.vectorgaming.vcore.VCoreAPI;
import net.vectorgaming.vcore.framework.commands.VCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

/**
 *
 * @author Kenny
 */
public class ArenaSignsBase extends VCommand
{
    public ArenaSignsBase()
    {
        super("arenasigns", ArenaSignsAPI.getPlugin());
        addSubCommand(new ArenaSignsCreate());
        addSubCommand(new ArenaSignsUpdate());
    }
    
    @Override
    public void run(CommandSender cs, String[] args)
    {
        cs.sendMessage(VCoreAPI.getColorScheme().getTitleBar("ArenaSigns Help"));
        cs.sendMessage(ChatColor.GREEN+"Type "+VCoreAPI.getColorScheme().getArgumentColor()+"/arenasigns help "+ChatColor.GREEN+"for a list of commands.");
    }

    @Override
    public String getDescription()
    {
        return "ArenaSigns base command";
    }

    @Override
    public String getUsage()
    {
        return "/arenasigns [<params>]";
    }

    @Override
    public String getPermission()
    {
        return "arenasigns.help";
    }

    @Override
    public Integer getMinArgsLength()
    {
        return 0;
    }

    @Override
    public Integer getMaxArgsLength()
    {
        return -1;
    }

    @Override
    public boolean isPlayerOnlyCommand()
    {
        return false;
    }

}
