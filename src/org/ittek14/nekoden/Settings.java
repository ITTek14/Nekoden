package org.ittek14.nekoden;

import org.newdawn.slick.GameContainer;

public class Settings {
	public static float getScale(GameContainer container){
		return Math.min((float)container.getHeight() / 270, (float)container.getWidth() / 500);
	}
}
