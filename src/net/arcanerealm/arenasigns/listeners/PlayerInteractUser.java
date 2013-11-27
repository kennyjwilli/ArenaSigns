
package net.arcanerealm.arenasigns.listeners;

import net.arcanerealm.arenasigns.ArenaSignsAPI;
import net.arcanerealm.arenasigns.framework.ArenaSign;
import net.vectorgaming.varenas.ArenaManager;
import net.vectorgaming.varenas.framework.Arena;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 *
 * @author Kenny
 */
public class PlayerInteractUser implements Listener
{
    @EventHandler
    public void onInteract(PlayerInteractEvent event)
    {
        if(event.getMaterial() != Material.SIGN && event.getMaterial() != Material.SIGN_POST && event.getMaterial() != Material.AIR)
        {
            return;
        }
        Player p = event.getPlayer();
        
        if(event.getClickedBlock() == null)
        {
            return;
        }
        
        if(!ArenaSignsAPI.isSignAtLocation(event.getClickedBlock().getLocation()))
        {
            return;
        }
        ArenaSign sign = ArenaSignsAPI.getSignAtLocation(event.getClickedBlock().getLocation());
        
        if(!ArenaManager.isArenaRunning(sign.getArenaName()))
        {
            p.sendMessage(ChatColor.RED+"This arena is not currently running.");
            return;
        }
        
        Arena arena = ArenaManager.getArena(sign.getArenaName());
        
        if(arena.canJoin(p))
        {
            ArenaManager.getArena(sign.getArenaName()).onJoin(p);
        }else
        {
            p.sendMessage(ChatColor.RED+"You cannot join at this time.");
        }
    }
}
