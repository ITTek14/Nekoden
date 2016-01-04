package org.ittek14.nekoden.entity;

import org.ittek14.nekoden.graphics.Sprite;
import org.lwjgl.input.Keyboard;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

public class Player extends Entity {
	protected Sprite sprite;
	
	public Player(Vector2f vector2f) {
		super(vector2f);
		sprite = new Sprite("playerD");
	}
	
	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) {
		float dist = (float)delta/4;
		if(Keyboard.isKeyDown(Keyboard.KEY_W))  {
			position.add(new Vector2f(0f, -dist));
			sprite = new Sprite("playerU");
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_S))  {
			position.add(new Vector2f(0f, dist));
			sprite = new Sprite("playerD");
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_A))  {
			position.add(new Vector2f(-dist, 0f));
			sprite = new Sprite("playerL");
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_D))  {
			position.add(new Vector2f(dist, 0f));
			sprite = new Sprite("playerR");
		}
	}
	
	@Override
	public void draw() {
		sprite.draw(position.getX(), position.getY());
	}
}
