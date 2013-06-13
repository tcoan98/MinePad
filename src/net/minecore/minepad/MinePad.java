package net.minecore.minepad;

import java.util.logging.Logger;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class MinePad extends JavaPlugin{

	private Logger log;
	@Override
	public void onLoad()
	{
		log = this.getLogger();
	}
	
	public void onEnable()
	{
		log.info("MinePad enabled!");
		this.getServer().getPluginManager().registerEvents(new WorldListener(), this);
	}
	
	public void onDisable()
	{
		log.info("MinePad disabled.");
	}
}
