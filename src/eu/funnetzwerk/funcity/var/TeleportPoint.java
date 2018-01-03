package eu.funnetzwerk.funcity.var;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class TeleportPoint {

	private Location location;
	
	private boolean alwaysTop = false;
	
	public TeleportPoint(Location l){
		this.location = l;
	}
	
	public void teleportEntity(Entity e) {
		
		if(alwaysTop) {
			this.location.setY(location.getWorld().getHighestBlockYAt(location));
		}
		
		e.teleport(this.location);
	}
	
	public void setAlwaysOnTop(boolean a) {
		this.alwaysTop = a;
	}
	
}
