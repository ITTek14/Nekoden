package org.ittek14.nekoden.entity;

import org.ittek14.nekoden.graphics.Sprite;

public class NPC extends Entity{
	protected String[] sprites;
	protected Sprite sprite;
	
	public NPC(String[] sprites){
		this.sprites = sprites;
		sprite = new Sprite(sprites[0]);
		this.id = "NPC";
	}
	
	public void draw() {
		sprite.draw(position.getX(), position.getY());
	}
}
