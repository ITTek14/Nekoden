package org.ittek14.nekoden.battle;

import org.ittek14.nekoden.graphics.Sprite;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

public class BattleAnime {
	private Sprite background;
	float regionWidth = 700, regionHeight = 100;
	private Rectangle uiRegion;
	
	public BattleAnime() {
		background = new Sprite("tile_grass");
	}
	
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		uiRegion = new Rectangle(container.getWidth() / 2f - regionWidth / 2f, container.getHeight() - regionHeight - 10f, regionWidth, regionHeight);
	}
	
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		background.draw(0f, 0f);
		g.draw(uiRegion);
	}

	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		
	}
}
