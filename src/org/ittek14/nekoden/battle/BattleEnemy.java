package org.ittek14.nekoden.battle;

import org.ittek14.nekoden.entity.Entity;
import org.ittek14.nekoden.graphics.Sprite;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

public abstract class BattleEnemy extends Entity {
	
	private String name;
	protected Sprite sprite, bigSprite;
	private Stats stats;
	
	public BattleEnemy(String name, Stats stats, Sprite sprite, Sprite bigSprite) {
		super();
		this.name = name;
		this.stats = stats;
		this.sprite = sprite;
		this.bigSprite = bigSprite;
	}
	
	public BattleEnemy(Vector2f position, String name, Stats stats, Sprite sprite, Sprite bigSprite) {
		super(position);
		this.name = name;
		this.stats = stats;
		this.sprite = sprite;
		this.bigSprite = bigSprite;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Stats getStats() {
		return stats;
	}
	
	public void setStats(Stats stats) {
		this.stats = stats;
	}
	
	public boolean isDead() {
		return stats.isDead();
	}
	
	public abstract void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException;
	
	public abstract void update(GameContainer container, StateBasedGame game, int delta) throws SlickException;
}
