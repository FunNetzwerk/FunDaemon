package com.heefly.cloud.daemon.vars;

import java.nio.file.Path;
import java.util.UUID;

public class GameServer {

	private UUID id;
	
	private String name;

	private Integer port;
	
	private Integer Xmx = 1024;
	private Integer Xms = 0;
	
	private Path path;
	
	public GameServer(UUID ID, GameServerStartParameters gssp) {
		
		this.id = ID;
		this.path = gssp.getPath();
		
		this.port = gssp.getPort();
		
		this.Xms = gssp.getMinRam();
		this.Xmx = gssp.getMaxRam();
		
		
	}
	
	public UUID getId() {
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

	public Integer getXmx() {
		return Xmx;
	}

	public void setXmx(Integer xmx) {
		Xmx = xmx;
	}

	public Integer getXms() {
		return Xms;
	}

	public void setXms(Integer xms) {
		Xms = xms;
	}

	public Path getPath() {
		return path;
	}
	
}
