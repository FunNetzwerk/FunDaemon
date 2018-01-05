package com.heefly.cloud.daemon.vars;

public class GameServer {

	private Integer id;
	
	private String name;

	private Integer port;
	
	public GameServer(int ID, GameServerStartParameters gssp) {
		
		this.id = ID;
		
		port = gssp.getPort();
		
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPort() {
		return port;
	}
	
}
