package org.ittek14.nekoden.graphics;

import org.ittek14.nekoden.Settings;
import org.ittek14.nekoden.entity.Entity;
import org.ittek14.nekoden.map.Map;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class Camera extends Entity {
	private Entity target = null;
	
	public Camera() {
		super();
	}
	
	public void lockOn(Entity e) {
		target = e;
	}
	
	public void unlock() {
		target = null;
	}
	
	public void translateGraphics(GameContainer container, Graphics g){
		g.translate(container.getWidth() / (2 * Settings.SCALE) - getPosition().getX(), container.getHeight() / (2 * Settings.SCALE) - getPosition().getY());
	}
	
	@Override
	public void update(GameContainer container, StateBasedGame game, Map map, int delta) {
		if(target != null) {
			setPosition(target.getPosition());
		}
	}
}
