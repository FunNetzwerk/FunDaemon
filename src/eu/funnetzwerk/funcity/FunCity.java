package eu.funnetzwerk.funcity;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import eu.funnetzwerk.funcity.cmd.TaxiCommand;
import eu.funnetzwerk.funcity.cmd.delTaxiCommand;
import eu.funnetzwerk.funcity.cmd.setTaxiCommand;
import eu.funnetzwerk.funcity.core.Taxi;
import eu.funnetzwerk.funcity.listener.PlayerInventoryClickListener;

public class FunCity extends JavaPlugin {

	private static Plugin plugin;
	
	private static Taxi taxiClass;
	
	private static File file_main = new File("plugins/FunCity", "config.yml");
	private static FileConfiguration cfg_main = YamlConfiguration.loadConfiguration(file_main);
	
	private static File file_taxi = new File("plugins/FunCity/locations", "taxistops.yml");
	private static FileConfiguration cfg_taxi = YamlConfiguration.loadConfiguration(file_taxi);
	
	@Override
	public void onEnable() {
		
		plugin = this;
		
		if(!file_main.exists()) {
			
			cfg_main.set("features.taxi", true);
			
			
			//TAXI OPTIONS
			cfg_main.set("options.taxi.costPerUse", 1);
			cfg_main.set("options.taxi.cooldown", 0);
			
			setCfg_main(cfg_main);
			
		}
		
		System.out.println("FunCity loaded! Activating features...");
		
		if(PluginFeatures.Taxi.isActive()) {
		
			System.out.println("Taxis => ENABLED");
			
			if(!file_taxi.exists()) {
				
				try {
					file_taxi.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			
		} else {
			System.out.println("Taxis => DISABLED");
		}
		
		taxiClass = new Taxi();
		
		Bukkit.getPluginManager().registerEvents(new PlayerInventoryClickListener(), this);
		
		getCommand("taxi").setExecutor(new TaxiCommand());
		getCommand("settaxi").setExecutor(new setTaxiCommand());
		getCommand("deltaxi").setExecutor(new delTaxiCommand());
		
	}
	
	public static Plugin getPlugin() {
		return plugin;
	}

	public static Taxi getTaxiClass() {
		return taxiClass;
	}

	public static FileConfiguration getCfg_taxi() {
		return cfg_taxi;
	}

	public static void setCfg_taxi(FileConfiguration cfg) {
		
		FunCity.cfg_taxi = cfg;
		
		try {
			cfg_taxi.save(FunCity.file_taxi);
		} catch (IOException e) {
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
			e.printStackTrace();
		}
		
	}
	
}
