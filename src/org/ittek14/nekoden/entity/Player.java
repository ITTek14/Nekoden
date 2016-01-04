package org.ittek14.nekoden.entity;

import java.util.Random;

import org.ittek14.nekoden.graphics.Sprite;
import org.lwjgl.input.Keyboard;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

public class Player extends Entity {
	protected Sprite sprite;
	protected int x,y;
	protected boolean moving;
	
	public Player(Vector2f vector2f) {
		super(vector2f);
		sprite = new Sprite("playerD");
		x = 10; 
		y = 10;
		setPosition(new Vector2f(x*16, y*16));
		moving = false;
	}
	
	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) {
		Vector2f target = new Vector2f(x*16,y*16);
		if(target.distance(position) < 1){
			if(Keyboard.isKeyDown(Keyboard.KEY_W))  {
				y--;
				sprite = new Sprite("playerU");
				moving = true;
			}else if(Keyboard.isKeyDown(Keyboard.KEY_S))  {
				y++;
				sprite = new Sprite("playerD");
				moving = true;
			}else if(Keyboard.isKeyDown(Keyboard.KEY_A))  {
				x--;
				sprite = new Sprite("playerL");
				moving = true;
			}else if(Keyboard.isKeyDown(Keyboard.KEY_D))  {
				x++;
				sprite = new Sprite("playerR");
				moving = true;
			}
		}
		if(target.distance(position) < 1){
			if(target.distance(position) > 0){
				position = target;
				if(new Random().nextInt(500) < 2){
					game.enterState(2);
				}
			}
		}else{
			position.add(target.sub(position).normalise().scale((float)delta/8));
		}
	}
	
	@Override
	public void draw() {
		sprite.draw(position.getX(), position.getY());
	}
}
