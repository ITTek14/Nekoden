package org.ittek14.nekoden.resource;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ImageResource extends Resource {
	private Image img;
	private boolean flipHorizontal, flipVertical;
	
	public ImageResource(String id) {
		super(id);
		flipHorizontal = false;
		flipVertical = false;
	}
	
	public void setFlipHorizontal(boolean value){
		flipHorizontal = value;
	}
	
	public void setFlipVertical(boolean value){
		flipVertical = value;
	}

	public void loadResource(String path) {
		try {
			img = new Image(path);
			img.setFilter(Image.FILTER_NEAREST);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public void setImage(Image img) {
		this.img = img;
	}
	
	public Image getImage() {
		return img.getFlippedCopy(flipHorizontal, flipVertical);
	}
}
