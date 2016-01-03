package org.ittek14.nekoden.map;

import org.ittek14.nekoden.graphics.Sprite;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

public class Tile {
	private Sprite sprite;
	
	public Tile() {}
	
	public Sprite getSprite() {
		return sprite;
	}
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void update(GameContainer container, StateBasedGame game, int delta) {
		
	}
	
	public void draw(float x, float y) {
		sprite.draw(x, y);
	}
}
