package org.ittek14.nekoden;

import org.newdawn.slick.GameContainer;

public class Settings {
	public static float getScale(GameContainer container){
		if(container.getAspectRatio() < 500/270)
			return (float)container.getHeight() / 270;
		else{
			return (float)container.getWidth() / 500;
		}
	}
}
