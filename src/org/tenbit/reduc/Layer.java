package org.tenbit.reduc;

import java.awt.Graphics;
import java.util.ArrayList;

import org.tenbit.reduc.entity.Entity;

public class Layer {

	private ArrayList<Entity> entities = new ArrayList<Entity>();

	public Layer() {

	}
	public void add(Entity e) {
		entities.add(e);
	}
	public void remove(Entity e) {
		entities.remove(e);
	}
	public void update(Graphics g) {
		System.out.println("entities.size(): " + entities.size());
		//System.out.println("entities: " + entities);
		for(int i = 0; i < entities.size(); i++) {
			entities.get(i).draw(g);
			System.out.println("entities: " + entities.get(i).getType());
		}
	}
	public void render() {
		
		Entity e = null;
		
		for(int i = 0; i < entities.size(); i++) {
			e = entities.get(i);
			e.updateTick();
			e.update();
		}
	}

}
