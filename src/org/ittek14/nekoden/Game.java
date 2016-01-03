package org.ittek14.nekoden;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.ittek14.nekoden.resource.ResourceManager;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Game extends BasicGame {
	
	public ResourceManager resourceManager;

	public Game(String gamename) {
		super(gamename);
	    // TODO insert video game here
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		resourceManager = new ResourceManager();
	}
	
	@Override
	public void update(GameContainer gc, int i) throws SlickException {}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		g.drawString("Nekoden Monogatari", 50, 50);
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
}