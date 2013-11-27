
package net.arcanerealm.arenasigns.listeners;

import net.arcanerealm.arenasigns.ArenaSignsAPI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

/**
 *
 * @author Kenny
 */
public class BlockBreakListener implements Listener
{
    @EventHandler
    public void onBreak(BlockBreakEvent event)
    {
        if(!ArenaSignsAPI.isSignAtLocation(event.getBlock().getLocation()))
        {
            return;
        }
        
        ArenaSignsAPI.deleteSign(event.getBlock().getLocation());
    }
}
