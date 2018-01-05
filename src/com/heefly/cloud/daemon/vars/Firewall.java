package com.heefly.cloud.daemon.vars;

import java.io.IOException;
import java.util.ArrayList;

public class Firewall {

	private String host_master = "0.0.0.0";
	private Runtime runtime;
	
	private static ArrayList<Integer> opened_ports = new ArrayList<Integer>()	; 
	
	public Firewall() throws IOException {
		
		runtime = Runtime.getRuntime();
		System.out.println("[Firewall] Firewall initiated!");
		
	}
	
	public void addServer(GameServer server) {
		
		if(host_master != null) {
			
			try {
				runtime.exec("iptables -I INPUT ! -s " + host_master + " -p tcp --dport " + server.getPort() + " -j DROP");
				opened_ports.add(server.getPort());
			} catch (IOException e) {
				System.out.println("[Firewall] Failed to add Server " + server.getName() + "! (" + e.getMessage() + ")");
			}
			
		}
		
	}
	
	public void removeServer(GameServer server) {
		
		if(host_master != null) {
			
			try {
				runtime.exec("iptables -D INPUT ! -s " + host_master + " -p tcp --dport " + server.getPort() + " -j DROP");
				opened_ports.remove(server.getPort());
			} catch (IOException e) {
				System.out.println("[Firewall] Failed to remove Server " + server.getName() + "! (" + e.getMessage() + ")");
			}
			
		}
		
	}

	public String getHost_master() {
		return host_master;
	}

	public void setHost_master(String host_master) {
		this.host_master = host_master;
	}
	
}
