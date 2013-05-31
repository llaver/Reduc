package org.tenbit.reduc;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.lwjgl.util.Timer;
import org.lwjgl.util.vector.Vector2f;
import org.tenbit.reduc.entity.AlienHorde;
import org.tenbit.reduc.entity.AlienShip;
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
	AlienHorde horde = new AlienHorde();
	PlayerShip pShip;
	AlienShip aShip;
		

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
		setCursor();

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

	private void setCursor() {
		// Transparent 16 x 16 pixel cursor image.
		BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);

		// Create a new blank cursor.
		Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");

		// Set the blank cursor to the JFrame.
		setCursor(blankCursor);
	}

	public void createLayers() {
		Layer tempLay;

		//Player		
				pShip = new PlayerShip();
				lm.add("PLAYER_SHIP", new Layer());
				tempLay = lm.getLayer("PLAYER_SHIP");

				if(tempLay != null) {
					pShip.spawn();
					lm.updateLayer("PLAYER_SHIP", tempLay);
					System.out.println("PLAYER_SHIP is not null.");
				} else {
					System.out.println("PLAYER_SHIP is null.");
				}
		
		//Aliens
		aShip = new AlienShip();
		lm.add("ENEMY", new Layer());
		tempLay = lm.getLayer("ENEMY");

		if(tempLay != null) {
			tempLay = horde.createHorde(tempLay, 20);
			lm.updateLayer("ENEMY", tempLay);
			System.out.println("ENEMY is not null.");
		} else {
			System.out.println("ENEMY is null.");
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
		g.clearRect(0, 0, 800, 600);
		Graphics2D g2 = (Graphics2D) g;
		mp.paint(g);
		lm.update(g);		
	}

	@Override
	public void run() {
		try {
			while(true) {
				Thread.currentThread().sleep(1);
				heartBeat();
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
