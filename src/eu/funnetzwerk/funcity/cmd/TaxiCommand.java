package eu.funnetzwerk.funcity.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TaxiCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		
		if(sender instanceof Player) {
			
			Player p = (Player) sender;
			
			if(p.hasPermission("FunCity.Taxi.Use")) {
				
				
				
			} else {
				p.sendMessage("§7Du kannst kein Taxi verwenden.");
			}
			
		}
		
		return true;
	}

}
