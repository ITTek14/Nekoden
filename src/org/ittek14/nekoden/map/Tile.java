package org.ittek14.nekoden.map;

import org.ittek14.nekoden.resource.ResourceManager;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class Tile {
	private String sprite;
	
	public Tile() {}
	
	public String getSprite() {
		return sprite;
	}
	
	public Tile(String _sprite) {
		sprite = _sprite;
	}
	
	public void update(GameContainer container, StateBasedGame game, int delta) {
		
	}
	
	public void render(GameContainer container, StateBasedGame game, Graphics g) {
		//g.drawImage(ResourceManager.get);
	}
}
