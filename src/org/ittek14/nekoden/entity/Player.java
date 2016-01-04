package org.ittek14.nekoden.entity;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

public class Player extends Entity {

	public Player(Vector2f vector2f, String sprite) {
		super(vector2f, sprite);
	}
	
	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) {
		float dist = (float)delta/4;
		if(Keyboard.isKeyDown(Keyboard.KEY_W))  {
			position.add(new Vector2f(0f, -dist));
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_S))  {
			position.add(new Vector2f(0f, dist));
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_A))  {
			position.add(new Vector2f(-dist, 0f));
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_D))  {
			position.add(new Vector2f(dist, 0f));
		}
	}
	
	public void render(GameContainer container, StateBasedGame game, Graphics g) {
		
	}
}
