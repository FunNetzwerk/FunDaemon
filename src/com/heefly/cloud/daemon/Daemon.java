package com.heefly.cloud.daemon;

import java.io.IOException;

import com.heefly.cloud.daemon.core.GameServerManager;
import com.heefly.cloud.daemon.vars.Firewall;

public class Daemon {

	private static Firewall classFirewall;
	private static GameServerManager classGameServerManager;
	
	public static void main(String[] args) {
		
		//STARTUP PROGRESS
		
		System.out.println("[Deamon] Starting Firewall...");
		try {
			classFirewall = new Firewall();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("[Deamon] Firewall startup failed!");
		}
		
		
		System.out.println("[Deamon] Starting Servermanager...");
		try {
			classGameServerManager = new GameServerManager();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("[Deamon] Servermanager startup failed!");
		}

		
	}

	public Firewall getClassFirewall() {
		return classFirewall;
	}
	
	public GameServerManager getclassGameServerManager() {
		return classGameServerManager;
	}

}
