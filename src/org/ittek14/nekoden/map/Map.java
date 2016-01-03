package org.ittek14.nekoden.map;

import java.util.ArrayList;

import org.ittek14.nekoden.entity.Entity;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class Map {
	public int width, height;
	public Tile[][] tiles;
	public ArrayList<Entity> entities = new ArrayList<Entity>();
	
	public Map(int w, int h){
		this.width = w; 
		this.height = h;
		tiles = new Tile[3][w*h];
	}
	
	public void update(GameContainer container, StateBasedGame game, int delta) {
		
	}
	
	public void render(GameContainer container, StateBasedGame game, Graphics g) {
		g.drawOval(100, 100, width*4, height*4, 5);
	}
}
