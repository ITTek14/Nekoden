package org.ittek14.nekoden.battle;

import org.ittek14.nekoden.graphics.Sprite;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

public class BattleAnime {
	private Sprite background;
	float regionWidth = 700, regionHeight = 100;
	private Rectangle uiRegion;
	
	public BattleAnime() {}
	
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		background = new Sprite("battleBackground", true);
		uiRegion = new Rectangle(container.getWidth() / 2f - regionWidth / 2f, container.getHeight() - regionHeight - 85f, regionWidth, regionHeight);
	}
	
	public void renderBackground(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {		
		background.draw(0f, 0f);
	}
	
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {	
		g.setColor(Color.lightGray);
		g.fill(uiRegion);
	}
	
	public Vector2f getRegionSize() {
		return new Vector2f(regionWidth, regionHeight);
	}
	
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		
	}
}
