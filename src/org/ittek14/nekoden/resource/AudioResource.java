package org.ittek14.nekoden.resource;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class AudioResource extends Resource {
	
	private Sound sound;
	
	public AudioResource(String id) {
		super(id);
	}

	public void loadResource(String path) {
		try {
			sound = new Sound(path);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public Sound getSound() {
		return sound;
	}
}
