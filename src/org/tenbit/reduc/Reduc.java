package org.tenbit.reduc;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.lwjgl.util.Timer;

public class Reduc extends JPanel implements Runnable, Observer {
	
	static public int SCREEN_WIDTH = 800;
	static public int SCREEN_HEIGHT = 600;
	
	// Variables used to calculate fps
    private int frames;
    static float deltas = 0;
    static float fps;
	
	static Timer timer = new Timer();
	static float lastTime = timer.getTime();
	
	// Measure time elapsed since last frame renderer
	// This is the heart variable of the engine
	public static float tick;
	
	public Reduc(JFrame par) {
		
		SCREEN_WIDTH = getWidth();
		SCREEN_HEIGHT = getHeight();
		new Thread(this).start();
		
		
		
	}
	
	public void createLayers() {
		
		
		
	}
	
	public static void heartBeat() {
		Timer.tick();
        tick = timer.getTime() - lastTime;
        deltas+= tick;
        lastTime = timer.getTime();
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		try
        {
		while(true)
		{
                Thread.currentThread().sleep(1);
                repaint();
            }
     
        } catch(InterruptedException e) {
        }
		
	}
	
}
