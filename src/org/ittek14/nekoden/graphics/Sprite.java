package org.ittek14.nekoden.graphics;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;

public class Sprite {
	public static final int STATIC = 0;
	public static final int ANIMATED = 1;
	
	private int mode;
	private Image image;
	private Animation animation;
	
	public Sprite(Image image){
		this.image = image;
		mode = STATIC;
	}
	
	public Sprite(Animation animation){
		this.animation = animation;
		mode = ANIMATED;
	}
	
	public void draw(float x, float y) {
		switch(mode) {
		case STATIC:
			image.draw(x, y);
			break;
		case ANIMATED:
			animation.draw(x, y);
			break;
		}
	}
}
