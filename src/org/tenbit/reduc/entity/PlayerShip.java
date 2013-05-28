package org.tenbit.reduc.entity;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import org.lwjgl.util.vector.Vector2f;
import org.tenbit.reduc.Layer;
import org.tenbit.reduc.LayerManager;
import org.tenbit.reduc.Observer;
import org.tenbit.reduc.Reduc;


public class PlayerShip extends Entity implements Observer {

	public static int mouseX;
	public static int mouseY;

	public PlayerShip() {
		super(IEntity.PLAYER_SHIP);
	}

	public void spawn() {
		Vector2f defPos= new Vector2f((Reduc.SCREEN_WIDTH/2), (Reduc.SCREEN_HEIGHT/2));
		Vector2f defSpd = new Vector2f(1.0f, 1.0f);
		LayerManager lm = new LayerManager();
		Layer tempLayer = lm.getLayer("PLAYER_SHIP");
		if (tempLayer != null)
			super.spawn(defPos, defSpd, tempLayer);
		System.out.println("X: " + super.position.x + " Y: " + super.position.y);
		System.out.println("pship spawn");
	}

	@Override
	public void updateKey(KeyEvent keyEvent) {
		System.out.println("keypressed: " + keyEvent.getKeyChar());
<<<<<<< HEAD
		if(keyEvent.getKeyCode() == (KeyEvent.VK_W)) {
			System.out.println("MOVE UP!");
			super.position.y -= 10;
		}
		if(keyEvent.getKeyCode() == (KeyEvent.VK_A)) {
			System.out.println("MOVE LEFT!");
			super.position.x -= 10;
		}
		if(keyEvent.getKeyCode() == (KeyEvent.VK_S)) {
			System.out.println("MOVE DOWN!");
			super.position.y += 10;
		}
=======
<<<<<<< HEAD

		switch (keyEvent.getKeyCode()) {
		case KeyEvent.VK_W:
			super.position.y -= 10;
			break;
		case KeyEvent.VK_S:
			super.position.y += 10;
			break;
		case KeyEvent.VK_D:
			super.position.x += 10;
			break;
		case KeyEvent.VK_A:
			super.position.x -= 10;
			break;
		case KeyEvent.VK_SPACE:
			fire();
=======
		if(keyEvent.getKeyCode() == (KeyEvent.VK_W)) {
			System.out.println("MOVE UP!");
			super.position.y -= 10;
>>>>>>> Image Resizing
		}
		if(keyEvent.getKeyCode() == (KeyEvent.VK_A)) {
			System.out.println("MOVE LEFT!");
			super.position.x -= 10;
		}
		if(keyEvent.getKeyCode() == (KeyEvent.VK_S)) {
			System.out.println("MOVE DOWN!");
			super.position.y += 10;
		}
>>>>>>> 306faa39feb7ddf87be4fb91d45ee5826e5b78fe
		if(keyEvent.getKeyCode() == (KeyEvent.VK_D)) {
			System.out.println("MOVE RIGHT!");
			super.position.x += 10;
		}
		
<<<<<<< HEAD
=======
	}

	public void fire() {
		System.out.println("FIRING");
>>>>>>> 306faa39feb7ddf87be4fb91d45ee5826e5b78fe
	}

	@Override
	public void updateMouse(MouseEvent mouseEvent) {

		if (mouseX == 0 && mouseY == 0) {
			mouseX = mouseEvent.getX();
			mouseY = mouseEvent.getY();
		}	
		super.position.x = mouseEvent.getX()-50;
		super.position.y = mouseEvent.getY()-67;

		mouseX = mouseEvent.getX();
		mouseY = mouseEvent.getY();
	}

	@Override
	public void updateClick(MouseEvent mouseEvent) {
		if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
			fire();
		}
	}

}
