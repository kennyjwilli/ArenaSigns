
package net.arcanerealm.arenasigns;

import net.arcanerealm.arenasigns.commands.ArenaSignsBase;
import net.arcanerealm.arenasigns.listeners.*;
import net.arcanerealm.arenasigns.util.SLAPI;
import net.vectorgaming.vcore.framework.VertexAPI;
import net.vectorgaming.vcore.framework.VertexPlugin;
import net.vectorgaming.vcore.framework.commands.CommandManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

/**
 *
 * @author Kenny
 */
public class ArenaSigns extends VertexPlugin
{
    private ArenaSignsAPI api;
    
    @Override
    public void onEnable()
    {
        api = new ArenaSignsAPI(this);
        registerEvents();
        setupCommands();
        SLAPI.loadAllSigns();
    }

    @Override
    public void onDisable()
    {
        SLAPI.saveAllSigns();
    }

    @Override
    public void setupCommands()
    {
        CommandManager.registerCommand(new ArenaSignsBase());
    }
    
    private void registerEvents()
    {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerInteractSignCreation(), this);
        pm.registerEvents(new PlayerInteractUser(), this);
        pm.registerEvents(new BlockBreakListener(), this);
    }

    @Override
    public Plugin getPlugin()
    {
        return this;
    }

    @Override
    public VertexAPI getAPI()
    {
        return api;
    }
    
}
