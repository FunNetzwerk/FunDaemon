package com.heefly.cloud.daemon.vars;

public class ServerThread implements Runnable {

	private boolean paused = false;
	
	@Override
	public void run() {
		
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
