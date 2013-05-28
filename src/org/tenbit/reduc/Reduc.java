package org.tenbit.reduc;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.lwjgl.util.Timer;
import org.lwjgl.util.vector.Vector2f;
import org.tenbit.reduc.entity.Entity;
import org.tenbit.reduc.entity.IEntity;
import org.tenbit.reduc.entity.PlayerShip;
import org.tenbit.reduc.util.MousePos;

public class Reduc extends JPanel implements Runnable, Observer {
	
	public static int SCREEN_WIDTH = 800;
	public static int SCREEN_HEIGHT = 600;
	
	// Variables used to calculate fps
    private int frames;
    static float deltas = 0;
    static float fps;
	
	static Timer timer = new Timer();
	static float lastTime = timer.getTime();
	
	MousePos mp = new MousePos();	
	PlayerShip pShip;

	public static Setup setup;
	
	// Measure time elapsed since last frame renderer
	// This is the heart variable of the engine
	public static float tick;
	
	//Layers
	LayerManager lm = new LayerManager();
	
	public Reduc(JFrame par) {
		new Thread(this).start();
		
		ImageManager im = new ImageManager();
		createLayers();
		
		setBackground(Color.BLACK);
		
		setup = new Setup();
		setup.addObserver(this);
		this.addKeyListener(setup);
		this.addMouseMotionListener(setup);
		this.addMouseListener(setup);
		addObservers();
		
		
	}
	private void addObservers() {
		setup.addObserver(new MousePos());
		setup.addObserver(pShip);
	}
	
	public void createLayers() {
		Layer tempLay;
		pShip = new PlayerShip();
		//Player
		lm.add("PLAYER_SHIP", new Layer());
		tempLay = lm.getLayer("PLAYER_SHIP");
		
		if(tempLay != null) {
			pShip.spawn();
			lm.updateLayer("PLAYER_SHIP", tempLay);
			System.out.println("temp not null");
		} else {
			System.out.println("temp null");
		}
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
		mp.paint(g);
		lm.update(g);		
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
