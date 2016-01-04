package org.ittek14.nekoden.battle;

import org.ittek14.nekoden.Settings;
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
	float regionWidth = 700, regionHeight = 200;
	private Rectangle uiRegion;
	
	public BattleAnime() {}
	
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		background = new Sprite("battleBackground");
		uiRegion = new Rectangle(container.getWidth() / 2f - regionWidth / 2f, container.getHeight() - regionHeight - 10f, regionWidth, regionHeight);
	}
	
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		float scale = Settings.getScale();
		g.scale(scale, scale);
		//g.translate(-container.getWidth() / 2 + 250, -container.getHeight() / 2 + 135);
	
		
		background.draw(0f, 0f);
		//g.draw(uiRegion);
		
		g.resetTransform();
		g.setColor(Color.black);
		g.fillRect(0, 0, (container.getWidth() - 500 * scale) / 2, container.getHeight());
		g.fillRect(0, 0, container.getWidth(), (container.getHeight() - 270 * scale) / 2);
		g.fillRect(container.getWidth(), 0, -(container.getWidth() - 500 * scale) / 2, container.getHeight());
		g.fillRect(0, container.getHeight(), container.getWidth(), -(container.getHeight() - 270 * scale) / 2);
	}
	
	public Vector2f getRegionSize() {
		return new Vector2f(regionWidth, regionHeight);
	}
	
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		
	}
}
