package eu.funnetzwerk.funcity;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import eu.funnetzwerk.funcity.cmd.TaxiCommand;
import eu.funnetzwerk.funcity.cmd.delTaxiCommand;
import eu.funnetzwerk.funcity.cmd.setTaxiCommand;
import eu.funnetzwerk.funcity.core.Taxi;

public class FunCity extends JavaPlugin {

	private static Plugin plugin;
	
	private Taxi taxiClass;
	
	private static File file_main = new File("/plugins/FunCity", "config.yml");
	private static FileConfiguration cfg_main = YamlConfiguration.loadConfiguration(file_main);
	
	private static File file_taxi = new File("/plugins/FunCity/locations", "taxi_stops.list");
	private static FileConfiguration cfg_taxi = YamlConfiguration.loadConfiguration(file_taxi);
	
	@Override
	public void onEnable() {
		
		plugin = this;
		
		System.out.println("FunCity loaded! Activating features...");
		
		if(PluginFeatures.Taxi.isActive()) {
		
			System.out.println("Taxis => ENABLED");
			
			if(file_taxi.exists()) {
				
				taxiClass = new Taxi();
				
			} else {
				
				try {
					file_taxi.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				taxiClass = new Taxi();
				
			}
			
		} else {
			System.out.println("Taxis => DISABLED");
		}
		
		setTaxiClass(new Taxi());
		
		getCommand("taxi").setExecutor(new TaxiCommand());
		getCommand("settaxi").setExecutor(new setTaxiCommand());
		getCommand("deltaxi").setExecutor(new delTaxiCommand());
		
	}
	
	public static Plugin getPlugin() {
		return plugin;
	}

	public Taxi getTaxiClass() {
		return taxiClass;
	}

	public void setTaxiClass(Taxi taxiClass) {
		this.taxiClass = taxiClass;
	}

	public static FileConfiguration getCfg_taxi() {
		return cfg_taxi;
	}

	public void setCfg_taxi(FileConfiguration cfg_taxi) {
		FunCity.cfg_taxi = cfg_taxi;
		
		try {
			cfg_taxi.save(file_taxi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static FileConfiguration getCfg_main() {
		return cfg_main;
	}

	public static void setCfg_main(FileConfiguration cfg_main) {
		FunCity.cfg_main = cfg_main;
		
		try {
			cfg_main.save(file_main);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
