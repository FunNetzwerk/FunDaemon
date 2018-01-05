package com.heefly.cloud.daemon.vars;

import java.nio.file.Path;

public class GameServerStartParameters {

	private Integer port;
	
	private Path path;
	
	private int maxRam;
	private int minRam;
	
	public Integer getPort() {
		return port;
	}

	public Path getPath() {
		return path;
	}

	public int getMaxRam() {
		return maxRam;
	}

	public void setMaxRam(int maxRam) {
		this.maxRam = maxRam;
	}

	public int getMinRam() {
		return minRam;
	}

	public void setMinRam(int minRam) {
		this.minRam = minRam;
	}

}
