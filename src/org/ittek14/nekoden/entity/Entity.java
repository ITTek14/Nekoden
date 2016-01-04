package org.ittek14.nekoden.entity;

import org.ittek14.nekoden.map.Map;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

public class Entity {
	protected String id="Entity";
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
	
	public String getID(){
		return id;
	}
	
	public void draw() {
	}

	public void update(GameContainer container, StateBasedGame game, Map map, int delta) {
		// TODO Auto-generated method stub
		
	}
}
