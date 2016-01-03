package org.ittek14.nekoden;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;

public class Settings {
	public static final int SCALE = 2;
	
	public static float getScale(GameContainer container){
		return new Vector2f(container.getWidth(), container.getHeight()).length() / (1000 / SCALE); 
	}
}
