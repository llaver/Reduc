package org.tenbit.reduc.entity;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import org.lwjgl.util.vector.Vector2f;
import org.tenbit.reduc.Layer;
import org.tenbit.reduc.LayerManager;
import org.tenbit.reduc.Observer;
import org.tenbit.reduc.Reduc;


public class PlayerShip extends Entity implements Observer {
	
	public PlayerShip() {
		super(IEntity.PLAYER_SHIP);
	}
	
	public void spawn() {
		Vector2f defPos= new Vector2f((float)Reduc.SCREEN_WIDTH/2, (float)Reduc.SCREEN_HEIGHT/2);
		Vector2f defSpd = new Vector2f(1.0f, 1.0f);
		LayerManager lm = new LayerManager();
		Layer tempLayer = lm.getLayer("playerShip");
		if (tempLayer!= null)
		super.spawn(defPos, defSpd, tempLayer);
	}

	@Override
	public void updateKey(KeyEvent keyEvent) {
	
	}

	@Override
	public void updateMouse(MouseEvent mouseEvent) {
	}

	@Override
	public void updateClick(MouseEvent mouseEvent) {
	}

}
