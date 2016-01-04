package org.ittek14.nekoden.entity;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

public class Player extends Entity {

	public Player(Vector2f vector2f, String sprite) {
		super(vector2f, sprite);
	}
	
	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) {
		if(Keyboard.isKeyDown(Keyboard.KEY_W))  {
			move(new Vector2f(0f, -1f));
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_S))  {
			move(new Vector2f(0f, 1f));
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_A))  {
			move(new Vector2f(-1f, 0f));
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_D))  {
			move(new Vector2f(1f, 0f));
		}
	}
}
