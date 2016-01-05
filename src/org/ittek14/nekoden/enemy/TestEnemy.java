package org.ittek14.nekoden.enemy;

import org.ittek14.nekoden.battle.BattleEnemy;
import org.ittek14.nekoden.battle.Stats;
import org.ittek14.nekoden.graphics.Sprite;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

public class TestEnemy extends BattleEnemy {

	public TestEnemy(Vector2f position) {
		super(position, "Test Enemy", new Stats(100, 100, 1), new Sprite("tile_grass", true), new Sprite("ghostBig", true));
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		// TODO Auto-generated method stubws
		bigSprite.draw(getPosition().x, getPosition().y);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		// TODO Auto-generated method stub
	}

}
