package org.ittek14.nekoden.graphics;

import org.ittek14.nekoden.entity.Entity;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

public class Camera {
	private Vector2f position = new Vector2f();
	private Entity target = null;
	
	public Camera() {
	}
	
	public void lockOn(Entity e) {
		target = e;
	}
	
	public void unlock() {
		target = null;
	}
	
	public void setPosition(Vector2f position) {
		this.position = position;
	}
	
	public Vector2f getPosition() {
		return position;
	}
	
	public void update(GameContainer container, StateBasedGame game, int delta) {
		if(target != null) {
			setPosition(target.getPosition());
		}
	}
}
