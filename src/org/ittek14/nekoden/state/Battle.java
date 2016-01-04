package org.ittek14.nekoden.state;

import org.ittek14.nekoden.battle.BattleAnime;
import org.ittek14.nekoden.gui.Button;
import org.ittek14.nekoden.gui.GUI;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

public class Battle implements GameState {
	private GUI gui;
	private BattleAnime battleAnime;
	
	@Override
	public void mouseClicked(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseWheelMoved(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inputEnded() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inputStarted() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAcceptingInput() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setInput(Input arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(int key, char c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(int key, char c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerButtonPressed(int controller, int button) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerButtonReleased(int controller, int button) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerDownPressed(int controller) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerDownReleased(int controller) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerLeftPressed(int controller) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerLeftReleased(int controller) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerRightPressed(int controller) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerRightReleased(int controller) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerUpPressed(int controller) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerUpReleased(int controller) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enter(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		battleAnime = new BattleAnime();
		battleAnime.init(arg0, arg1);
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		gui = new GUI();
		battleAnime = new BattleAnime();
		gui.addWidget(new Button(container, new Vector2f(container.getWidth() / 2f - battleAnime.getRegionSize().x / 2f + 25f, container.getHeight() - battleAnime.getRegionSize().y - 10f + 20f), "Atk", new Vector2f(50, 40)){
			@Override
			public void onClick(int button) {
				game.enterState(1);
			}
		});
		gui.addWidget(new Button(container, new Vector2f(container.getWidth() / 2f - battleAnime.getRegionSize().x / 2f + 25f, container.getHeight() - battleAnime.getRegionSize().y - 10f + 20f + 50f), "Deff", new Vector2f(50, 40)){
			@Override
			public void onClick(int button) {
				game.enterState(1);
			}
		});
		gui.addWidget(new Button(container, new Vector2f(container.getWidth() / 2f - battleAnime.getRegionSize().x / 2f + 25f, container.getHeight() - battleAnime.getRegionSize().y - 10f + 20f + 100f), "Bag", new Vector2f(50, 40)){
			@Override
			public void onClick(int button) {
				game.enterState(1);
			}
		});
		gui.addWidget(new Button(container, new Vector2f(container.getWidth() / 2f - battleAnime.getRegionSize().x / 2f + 35f, container.getHeight() - battleAnime.getRegionSize().y - 10f + 20f + 160f), "Run", new Vector2f(70, 40)){
			@Override
			public void onClick(int button) {
				game.enterState(1);
			}
		});
	}

	@Override
	public void leave(GameContainer container, StateBasedGame game) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		battleAnime.render(container, game, g);
		g.drawString("BATTLE!!!!", 100, 50);
		gui.render(container, g);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		// TODO Auto-generated method stubws
		battleAnime.update(container, game, delta);
		gui.update(container, delta);
	}

}
