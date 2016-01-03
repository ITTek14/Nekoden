package org.ittek14.nekoden.managers;

import org.newdawn.slick.SlickException;

public class Sound extends Resource {
	
	public org.newdawn.slick.Sound sound;
	
	public Sound(String id) {
		super(id);
	}

	@Override
	public void loadResource(String path) {
		try {
			sound = new org.newdawn.slick.Sound(path);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}
