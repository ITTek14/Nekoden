package org.ittek14.nekoden.entity;

import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class Entity {
	
	private Vector2f position;
	private String sprite;
	
	public Entity() {}
	
	public Entity(Vector2f position, String sprite) {
		this.position = position;
		this.sprite = sprite;
	}
	
	public void move(Vector2f offset) {
		Vector2f.add(position, offset, position);
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
		//TODO: g.drawImage(, x, y, x2, y2, srcx, srcy, srcx2, srcy2, col);
	}
}
