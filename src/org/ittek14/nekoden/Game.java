package org.ittek14.nekoden;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.ittek14.nekoden.state.Loading;
import org.ittek14.nekoden.state.Overworld;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends StateBasedGame {

	public Game(String gamename) {
		super(gamename);
	}
	public static void main(String[] args) {
		try {
			AppGameContainer appgc;
			appgc = new AppGameContainer(new Game("Nekoden Monogatari"));
			appgc.setDisplayMode(800, 600, false);
			appgc.start();
		} catch (SlickException ex) {
			Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		// TODO Auto-generated method stub
		addState(new Loading());
		addState(new Overworld());
	}
}