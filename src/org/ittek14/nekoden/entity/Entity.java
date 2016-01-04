package org.ittek14.nekoden.entity;

import org.ittek14.nekoden.resource.ImageResource;
import org.ittek14.nekoden.resource.ResourceManager;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import org.newdawn.slick.geom.Vector2f;import org.newdawn.slick.state.StateBasedGame;

public class Entity {
	
	protected Vector2f position;
	protected String sprite;
	
	public Entity() {
	}
	
	public Entity(Vector2f vector2f, String sprite) {
		this.position = vector2f;
		this.sprite = sprite;
	}
	
	public void setPosition(Vector2f position) {
		this.position = position;
	}
	
	public Vector2f getPosition() {
		return position;
	}
	
	public void update(GameContainer container, StateBasedGame game, int delta) {
		
	}
	
	public void render(GameContainer container, StateBasedGame game, Graphics g) {
		g.drawImage(((ImageResource) ResourceManager.getImageResource(sprite)).getImage(), position.x, position.y);
	}
}
