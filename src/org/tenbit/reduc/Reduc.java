package org.tenbit.reduc;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.lwjgl.util.Timer;
import org.tenbit.reduc.entity.IEntity;

public class Reduc extends JPanel implements Runnable, Observer {
	
	static public int SCREEN_WIDTH = 800;
	static public int SCREEN_HEIGHT = 600;
	
	// Variables used to calculate fps
    private int frames;
    static float deltas = 0;
    static float fps;
	
	static Timer timer = new Timer();
	static float lastTime = timer.getTime();
	

	public static Setup setup;
	
	// Measure time elapsed since last frame renderer
	// This is the heart variable of the engine
	public static float tick;
	
	public Reduc(JFrame par) {
		
		SCREEN_WIDTH = getWidth();
		SCREEN_HEIGHT = getHeight();
		new Thread(this).start();
		
		ImageManager im = new ImageManager();
		
		setBackground(Color.BLACK);
		
		setup = new Setup();
		setup.addObserver(this);
		this.addKeyListener(setup);
		this.addMouseMotionListener(setup);
		this.addMouseListener(setup);
		addObservers();
		
	}
	private void addObservers() {
		//setup.addObserver(new MousePos());
		//setup.addObserver(menu);
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
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.clearRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		g2.drawImage(ImageManager.getImage(IEntity.PLAYER_SHIP), 400, 250, null);
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

	@Override
	public void updateKey(KeyEvent keyEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMouse(MouseEvent mouseEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateClick(MouseEvent mouseEvent) {
		// TODO Auto-generated method stub
		
	}
	
}
