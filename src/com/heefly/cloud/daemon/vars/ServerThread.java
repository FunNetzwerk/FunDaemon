package com.heefly.cloud.daemon.vars;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ServerThread implements Runnable {

	private boolean paused = false;
	
	ProcessBuilder processBuilder;
	Process process;
	
	OutputStream stream_out;
	InputStream stream_err;
	InputStream stream_in;
	
	public ServerThread(GameServer server) throws IOException {
		processBuilder = new ProcessBuilder("java", "",
			
			"-Xms"+server.getXms()+"G -Xmx"+server.getXmx()+"G",
			"-Dfile.encoding=UTF-8",
				
			// == GC Tuning ==
			// This is low pause, keep server from ever lag spiking.
			// Very good details on why this is beneficial for MC: http://www.oracle.com/technetwork/java/gc-tuning-5-138395.html#0.0.0. The Concurrent Low Pause Collector|outline
			//Uses more CPU but we have unused cores. So this is beneficial to keep TPS hit low.
			"-XX:+UseConcMarkSweepGC",
			"-XX:+UseParNewGC",
			
			// Enable I-CMS, optimizing pauses and distrbutes GC over longer period so TPS keeps stable
			"-XX:+CMSIncrementalMode -XX:+CMSIncrementalPacing",
			"-XX:+CMSParallelRemarkEnabled", // Use multiple threads for CMS Sweeps
			"-XX:MaxGCPauseMillis=50", // try to keep it at 1 TPS loss max (not guaranteed)
			"-XX:+DisableExplicitGC", // Prevent plugins causing GC
			
			// == Misc Tweaks==
			"-XX:+AggressiveOpts", // Enables soon-to-be-default optimizations.
			"-XX:+UseFastAccessorMethods", // Optimizes getters... pretty respectable deal.
			"-XX:+UseBiasedLocking", // Enables a technique for improving the performance of uncontested synchronization.
			// Bukkit and Spigot synchronizes things for safety that is never contended under ideal cases. This
			// Optimizes those cases, so that uncontested syncs are much cheaper.
			
			// == Memory Management ==
			"-XX:TargetSurvivorRatio=90", // Use the survivor area more efficiently.
			//.' -XX:+UseLargePages' // The biggest gain, but we need to configure system to use it first
				
			"-jar "
		);
		
	}
	
	@Override
	public void run() {
		
		try {
			process = processBuilder.start();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		stream_out = process.getOutputStream();
		stream_err = process.getErrorStream();
		stream_in = process.getInputStream();
		
		//PAUSE CONTINUE PROCESS!
		synchronized (this) {
            while (paused) {
               try {
                  wait();
               } catch (Exception e) {
                  e.printStackTrace();
               }
            }
         }
		
	}

	public void pause() {
		paused = true;
	}
	
	public void resume() {
		paused = false;
		notify();
	}
	
}
