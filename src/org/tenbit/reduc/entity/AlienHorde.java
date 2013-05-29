package org.tenbit.reduc.entity;

import org.lwjgl.util.vector.Vector2f;
import org.tenbit.reduc.Layer;
import org.tenbit.reduc.Reduc;

public class AlienHorde {

	AlienShip a;
	int maxRow = 10;
	int row = 1;

	public AlienHorde() {

	}

	//num = number of aliens to spawn
	public Layer createHorde(Layer layer, int num) {
		if(layer != null) {
			for(int i = 0; i < num; i++) {
				int space = (Reduc.SCREEN_WIDTH / num);
				a = new AlienShip();
				a.spawn(new Vector2f((space + space * i), 15));
				layer.add(a);
			}
		}
		return layer;
	}

}
