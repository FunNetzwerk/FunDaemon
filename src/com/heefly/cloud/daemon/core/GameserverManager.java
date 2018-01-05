package com.heefly.cloud.daemon.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import com.heefly.cloud.daemon.vars.GameServer;
import com.heefly.cloud.daemon.vars.GameServerStartParameters;

public class GameServerManager extends Thread {

	private static HashMap<UUID, GameServer> server_list = new HashMap<UUID, GameServer>();
	
	private static int starting_servers = 0; 
	
	public GameServerManager() throws IOException {
		start();
	}
	
	@Override
	public void run() {
		
		ArrayList<GameServerStartParameters> starting_servers = new ArrayList<GameServerStartParameters>();
		
		for(GameServerStartParameters start_server : starting_servers){
			
			UUID uuid = UUID.randomUUID();
			
			try {
				server_list.put(uuid, new GameServer(uuid, start_server));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	public static int getStarting_servers() {
		return starting_servers;
	}

	public static void setStarting_servers(int starting_servers) {
		GameServerManager.starting_servers = starting_servers;
	}
	
}
