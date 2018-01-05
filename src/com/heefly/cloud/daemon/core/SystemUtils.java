package com.heefly.cloud.daemon.core;

public class SystemUtils {

	public static int getCPUCores() {
		return Runtime.getRuntime().availableProcessors();
	}
	
}
