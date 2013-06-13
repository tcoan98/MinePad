package net.minecore.minepad;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class WorldListener implements Listener {

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e)
	{
		if(!e.getAction().equals(Action.RIGHT_CLICK_AIR) && !e.getAction().equals(Action.RIGHT_CLICK_BLOCK))
		{
			return;
		}
		
		if(!e.getMaterial().equals(Material.WRITTEN_BOOK))
			return;
		BookMeta bm = (BookMeta) e.getItem().getItemMeta();
		if(!bm.hasTitle())
			return;
		if(bm.getTitle().equalsIgnoreCase("Minepad"))
		{
			bm.setTitle("MinePad");
			e.getPlayer().sendMessage("You have made a MinePad!");
			
			
		}
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e){
		
		for(ItemStack is : e.getPlayer().getInventory())
		{
			if(is != null && is.getType().equals(Material.WRITTEN_BOOK))
			{
				BookMeta bm = (BookMeta) is.getItemMeta();
				if(!bm.hasTitle())
					continue;
				if(bm.getTitle().equalsIgnoreCase("MinePad"))
				{
					String s =  bm.getPage(1);
					System.out.println(s);
					bm.setPage(1, "test");
					
					
					e.getPlayer().sendMessage("You broke a" + e.getBlock().getType());
				}
			}
		}
	}
	
}
