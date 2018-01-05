package com.heefly.cloud.daemon.core;

public class SystemUtils {

	public int getCPUCores() {
		return Runtime.getRuntime().availableProcessors();
	}
	
}
