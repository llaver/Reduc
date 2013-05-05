package org.tenbit.reduc;

import org.lwjgl.util.Timer;

public class Reduc {
	
	static public final int SCREEN_WIDTH = 800;
	static public final int SCREEN_HEIGHT = 600;
	
	// Variables used to calculate fps
    private int frames;
    static float deltas = 0;
    static float fps;
	
	static Timer timer = new Timer();
	static float lastTime = timer.getTime();
	
	// Measure time elapsed since last frame renderer
	// This is the heart variable of the engine
	public static float tick;
	
	
	
	
	public static void heartBeat() {
		Timer.tick();
        tick = timer.getTime() - lastTime;
        deltas+= tick;
        lastTime = timer.getTime();
		
	}
	
	
}
