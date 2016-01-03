package org.ittek14.nekoden.managers;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ImageResource extends Resource {
	
	public Image img;
	
	public ImageResource(String id) {
		super(id);
	}

	@Override
	public void loadResource(String path) {
		try {
			img = new Image(path);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}
