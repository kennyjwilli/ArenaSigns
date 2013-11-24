
package net.arcanerealm.arenasigns.listeners;

import net.arcanerealm.arenasigns.ArenaSignsAPI;
import net.arcanerealm.arenasigns.commands.ArenaSignsCreate;
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
public class PlayerInteractSignCreation implements Listener
{
    @EventHandler
    public void onInteract(PlayerInteractEvent event)
    {
        Player p = event.getPlayer();
        
        if(!ArenaSignsCreate.canCreateSign(p))
        {
            return;
        }
        
        event.getClickedBlock().setType(Material.SIGN_POST);
        ArenaSignsAPI.createSign(event.getClickedBlock().getLocation(), ArenaSignsCreate.getMapFromCreator(p), ArenaSignsCreate.getArenaFromCreator(p));
        p.sendMessage(ChatColor.GREEN+"Created arena sign!");
        ArenaSignsCreate.disableSignCreation(p);
    }
}
