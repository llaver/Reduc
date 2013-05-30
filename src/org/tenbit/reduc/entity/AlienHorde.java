package org.tenbit.reduc.entity;

import org.lwjgl.util.vector.Vector2f;
import org.tenbit.reduc.Layer;
import org.tenbit.reduc.Reduc;

public class AlienHorde {

	AlienShip a;
	private int maxRow = 10;
	private int row = 1;
	private int y = 30;
	private int space;
	private int rowSpace;
	
	public AlienHorde() {

	}

	//num = number of aliens to spawn
	public Layer createHorde(Layer layer, int num) {
		if(layer != null) {
			if(num < maxRow) {
				space = (Reduc.SCREEN_WIDTH / num);
			} else {
				space = (Reduc.SCREEN_WIDTH / maxRow);
			}
			rowSpace = space;
			System.out.println("rowSpace = " + rowSpace);
			for(int i = 0; i < num; i++) {
				a = new AlienShip();
				if(num > maxRow && i != 0) {
					if(i % maxRow == 1) {
						row++;
						y = 30;
						y = y * row;
						rowSpace = space;
					}
				}
				a.spawn(new Vector2f(rowSpace, y));
				rowSpace += space;
				layer.add(a);
			}
		}
		return layer;
	}

}
