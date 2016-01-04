package org.ittek14.nekoden.entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

public class Entity {
	
	protected Vector2f position;
	
	public Entity() {
	}
	
	public Entity(Vector2f vector2f) {
		this.position = vector2f;
	}
	
	public void setPosition(Vector2f position) {
		this.position = position;
	}
	
	public Vector2f getPosition() {
		return position;
	}
	
	public void update(GameContainer container, StateBasedGame game, int delta) {
		
	}
	
	public void draw() {
	}
}
