package org.tenbit.reduc;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

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

	public static BufferedImage getImage(int imageID) {
		return images[imageID];
	}

	private void loadFiles() {
		files[IEntity.PLAYER_SHIP] = new File("src/data/PlayerShip.png");
		files[IEntity.ALIEN_SHIP_1] = new File("src/data/AlienShip.png");		

	}
	private void loadImages() {
		try {
			images[IEntity.PLAYER_SHIP] = ImageIO.read(files[IEntity.PLAYER_SHIP]);
			images[IEntity.ALIEN_SHIP_1] = ImageIO.read(files[IEntity.ALIEN_SHIP_1]);
			resizeImages();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void resizeImages() {
		for(int i = 0; i < images.length; i++) {
			if(images[i] != null) {	
				images[i] = resize(images[i], images[i].getWidth() / 3, images[i].getHeight() / 3);
			}
		}
	}

	public static BufferedImage resize(BufferedImage img, int newW, int newH) {   
		int w = img.getWidth();   
		int h = img.getHeight();   
		BufferedImage dimg = new BufferedImage(newW, newH, img.getType());   
		Graphics2D g = dimg.createGraphics();   
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);   
		g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);   
		g.dispose();   
		return dimg;   
	}   

}
