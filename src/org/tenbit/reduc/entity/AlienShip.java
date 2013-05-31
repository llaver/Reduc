package org.tenbit.reduc.entity;

import org.lwjgl.util.vector.Vector2f;
import org.tenbit.reduc.Layer;
import org.tenbit.reduc.LayerManager;
import org.tenbit.reduc.Reduc;

public class AlienShip extends Entity {
	
	LayerManager lm = new LayerManager();

	public AlienShip() {
		super(IEntity.ALIEN_SHIP_1);
	}
	
	public void spawn(Vector2f position) {
		Vector2f defSpd = new Vector2f(50f, 0f);
		Layer tempLayer = lm.getLayer("ENEMY");
		if (tempLayer != null)
			super.spawn(position, defSpd, tempLayer);
		System.out.println("X: " + super.position.x + " Y: " + super.position.y);
		System.out.println("aship spawn");
		
	}
	
/*	@Override
	public void update() {
		position = interpolate(position,speed);
		if (this.position.x - this.width > (Reduc.SCREEN_WIDTH / 2) || this.position.x + this.width < - (Reduc.SCREEN_WIDTH / 2)) {
			unSpawn();
			//if (Logger.isLogActivate) Logger.log(this.getClass().getName()+" died");
			return;
		}
	}*/

}
