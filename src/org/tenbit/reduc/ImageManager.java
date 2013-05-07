package org.tenbit.reduc;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.tenbit.reduc.entity.IEntity;

public class ImageManager {
	
	private static File[] files = new File[1024];
	private static BufferedImage[] images = new BufferedImage[1024];
	
	
	public ImageManager() {
		
		//Load Files
		loadFiles();
		
		//Load Images
		loadImages();
		
	}
	
	public BufferedImage getImage(int imageID) {
		return images[imageID];
	}
	
	private void loadFiles() {
		files[IEntity.PLAYER_SHIP] = new File("data/PlayerShip.png");
		files[IEntity.ALIEN_SHIP_1] = new File("data/AlienShip.png");		
		
	}
	private void loadImages() {
		try {
			images[IEntity.PLAYER_SHIP] = ImageIO.read(files[IEntity.PLAYER_SHIP]);
			images[IEntity.ALIEN_SHIP_1] = ImageIO.read(files[IEntity.ALIEN_SHIP_1]);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
