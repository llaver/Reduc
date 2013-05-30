package org.tenbit.reduc.entity;

import org.lwjgl.util.vector.Vector2f;
import org.tenbit.reduc.Layer;
import org.tenbit.reduc.LayerManager;
import org.tenbit.reduc.Reduc;

public class Bullet extends Entity {
	
	public Bullet() {
		super(IEntity.BULLET);
	}
	
	public void spawn() {
		Vector2f defSpd = new Vector2f(1.0f, 1.0f);
		LayerManager lm = new LayerManager();
		Layer tempLayer = lm.getLayer("BULLET");
		Entity ship = lm.getLayer("PLAYER_SHIP").getEntityAtIndex(0);
		
		if (tempLayer != null)
			super.spawn(ship.position, defSpd, tempLayer);
		System.out.println("X: " + super.position.x + " Y: " + super.position.y);
		System.out.println("bullet spawn");
		
	}

}
