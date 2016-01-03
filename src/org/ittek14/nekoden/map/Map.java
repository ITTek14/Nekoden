package org.ittek14.nekoden.map;

import java.util.ArrayList;

import org.ittek14.nekoden.entity.Entity;
import org.ittek14.nekoden.resource.ImageResource;
import org.ittek14.nekoden.resource.ResourceManager;
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
		
		for(int layer = 0; layer < 3; layer++) {
			for(int tile = 0; tile < w*h; tile++) {
				 tiles[layer][tile] = new Tile("grass");
			}
		}
	}
	
	public void update(GameContainer container, StateBasedGame game, int delta) {
		
	}
	
	public void render(GameContainer container, StateBasedGame game, Graphics g) {
		for(Tile[] layer : tiles) {
			for(int y = 0; y < height; y++) {
				for(int x = 0; x < width; x++) {
					if(layer[x+y*width] != null){
						g.drawImage(((ImageResource) ResourceManager.getImageResource("tile_grass")).getImage(), x * 32, y * 32);
					}
				}
			}
		}
	}
}
