package eu.funnetzwerk.funcity.core;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;

import eu.funnetzwerk.funcity.FunCity;
import eu.funnetzwerk.funcity.var.TeleportPoint;

public class Taxi {

	private ArrayList<TeleportPoint> taxi_stops = new ArrayList<TeleportPoint>();
	
	public Taxi() {
		
		FileConfiguration cfg = FunCity.getCfg_taxi();
		
		for(String s : cfg.getConfigurationSection("").getKeys(false)) {
			
			Location current;
			TeleportPoint tPoint;
			
			double x = cfg.getDouble(s + ".x");
			double y = cfg.getDouble(s + ".y");
			double z = cfg.getDouble(s + ".z");
			float yaw = (float) cfg.getDouble(s + ".yaw");
			float pitch = (float) cfg.getDouble(s + ".pitch");
			String worldname = cfg.getString(s + ".world");
			World w = Bukkit.getWorld(worldname);
			
			current = new Location(w, x, y, z, yaw, pitch);
			tPoint = new TeleportPoint(current);
			
			tPoint.setAlwaysOnTop(false);
			
			taxi_stops.add(tPoint);
		}
		
	}
	
	public void addPoint(String name, Location loc) {
		
		
		
	}
	
	public void teleport(Entity e, TeleportPoint tp) {
		tp.teleportEntity(e);
	}
	
}
