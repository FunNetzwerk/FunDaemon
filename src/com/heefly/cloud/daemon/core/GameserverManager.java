package com.heefly.cloud.daemon.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import com.heefly.cloud.daemon.vars.GameServer;
import com.heefly.cloud.daemon.vars.GameServerStartParameters;

public class GameServerManager extends Thread {

	private static HashMap<UUID, GameServer> server_list = new HashMap<UUID, GameServer>();
	
	public GameServerManager() throws IOException {
		start();
	}
	
	@Override
	public void run() {
		
		ArrayList<GameServerStartParameters> starting_servers = null;
		
		for(GameServerStartParameters start_server : starting_servers){
			
			UUID uuid = UUID.randomUUID();
			
			server_list.put(uuid, new GameServer(uuid, start_server));
			
		}
		
	}
	
}
