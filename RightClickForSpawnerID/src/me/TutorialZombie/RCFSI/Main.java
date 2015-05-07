package me.TutorialZombie.RCFSI;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	
	public void onEnable(){
		this.getServer().getPluginManager().registerEvents(this, this);
	}
	
	//Returns A Message With Creature Type
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e){
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
			if(e.getClickedBlock().getType() == Material.MOB_SPAWNER){
				if(e.getPlayer().hasPermission(new Permission("RCFSI"))){
					CreatureSpawner cs = (CreatureSpawner) e.getClickedBlock().getState();
					e.getPlayer().sendMessage(ChatColor.GREEN + cs.getCreatureTypeName() +" Spawner" + ChatColor.AQUA + " " + cs.getTypeId() + ":" + cs.getSpawnedType().getTypeId());
				}
			}
		}	
	}
	
}