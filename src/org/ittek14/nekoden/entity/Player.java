package org.ittek14.nekoden.entity;

import java.util.Random;

import org.ittek14.nekoden.battle.Stats;
import org.ittek14.nekoden.graphics.Sprite;
import org.ittek14.nekoden.map.Map;
import org.lwjgl.input.Keyboard;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

public class Player extends Entity {
	private Sprite sprite;
	private int x,y;
	private boolean moving;
	private Stats stats;
	
	public Player(Vector2f vector2f) {
		super(vector2f);
		sprite = new Sprite("playerD");
		x = 10; 
		y = 10;
		setPosition(new Vector2f(x*16, y*16));
		moving = false;
		this.stats = new Stats(50, 50, 20);
	}
	
	@Override
	public void update(GameContainer container, StateBasedGame game, Map map, int delta) {
		Vector2f target = new Vector2f(x*16,y*16);
		if(target.distance(position) < 1){
			if(Keyboard.isKeyDown(Keyboard.KEY_W) && map.isEmpty(x*16, (y-1)*16, 1))  {
				y--;
				sprite = new Sprite("playerU");
				moving = true;
			}else if(Keyboard.isKeyDown(Keyboard.KEY_S) && map.isEmpty(x*16, (y+1)*16, 1))  {
				y++;
				sprite = new Sprite("playerD");
				moving = true;
			}else if(Keyboard.isKeyDown(Keyboard.KEY_A) && map.isEmpty((x-1)*16, y*16, 1))  {
				x--;
				sprite = new Sprite("playerL");
				moving = true;
			}else if(Keyboard.isKeyDown(Keyboard.KEY_D) && map.isEmpty((x+1)*16, y*16, 1))  {
				x++;
				sprite = new Sprite("playerR");
				moving = true;
			}
		}
		if(target.distance(position) < 1){
			if(target.distance(position) > 0){
				position = target;
				if(new Random().nextInt(10) < 2){
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
