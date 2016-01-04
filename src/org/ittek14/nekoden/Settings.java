package org.ittek14.nekoden;

import org.newdawn.slick.geom.Vector2f;

public class Settings {
	public static int width,height;
	
	public static float getScale(){
		return Math.min((float)height / 270, (float)width / 500);
	}
	
	public static Vector2f toMetaCoordinates(Vector2f source) {
		float scale = getScale();
		return new Vector2f(width - 500 * scale / 2 + source.getX() * scale, 
				height - 500 * scale / 2 + source.getX() * scale);
	}
}
