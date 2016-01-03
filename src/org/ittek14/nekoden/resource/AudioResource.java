package org.ittek14.nekoden.resource;

import org.newdawn.slick.SlickException;

public class AudioResource extends Resource {
	
	public org.newdawn.slick.Sound sound;
	
	public AudioResource(String id) {
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
