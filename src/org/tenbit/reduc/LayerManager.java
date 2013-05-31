package org.tenbit.reduc;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LayerManager {
	
	//private ArrayList<Layer> layers = new ArrayList<Layer>();
	private static Map<String, Layer> layers = new HashMap<String, Layer>();
	
	public LayerManager() {
		
	}
	public void add(String name, Layer l) {
		layers.put(name, l);
	}
	public void remove(String name) {
		layers.remove(name);
	}
	public void updateLayer(String name, Layer l) {
		layers.put(name, l);
	}
	public void update(Graphics g) {
		for(int i = 0; i < layers.size(); i++) {
			if(layers.get(getNames().toArray()[i]) != null) {
				System.out.println("Updating Layer: " + getNames().toArray()[i]);
				layers.get(getNames().toArray()[i]).update(g);
				layers.get(getNames().toArray()[i]).render();
			} else {
			}
		}
	}
	public Map<String, Layer> getLayers() {
		return layers;
	}
	public Layer getLayer(String name) {
		return layers.get(name);		
	}
	public Set<String> getNames() {
		return layers.keySet();
	}
}
