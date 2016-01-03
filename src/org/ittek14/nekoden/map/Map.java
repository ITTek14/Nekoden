package org.ittek14.nekoden.map;

import java.util.ArrayList;

import org.ittek14.nekoden.Settings;
import org.ittek14.nekoden.entity.Entity;
import org.ittek14.nekoden.resource.ImageResource;
import org.ittek14.nekoden.resource.ResourceManager;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

public class Map {
	private int width, height;
	private Vector2f camera;
	private Tile[][] tiles;
	private ArrayList<Entity> entities = new ArrayList<Entity>();
	private Animation test;
	public Map(int w, int h){
		this.width = w; 
		this.height = h;
		tiles = new Tile[3][w*h];
		for(int layer = 0; layer < 3; layer++) {
			for(int tile = 0; tile < w*h; tile++) {
				 tiles[layer][tile] = new Tile("tile_grass");
			}
		}
		camera = new Vector2f(0,0);
		test = ResourceManager.getAnimationResource("tile_water").getAnimation();
	}
	
	public void update(GameContainer container, StateBasedGame game, int delta) {
		
	}
	
	public void render(GameContainer container, StateBasedGame game, Graphics g) {
		g.translate(container.getWidth() / (2 * Settings.SCALE), container.getHeight() / (2 * Settings.SCALE));
		for(Tile[] layer : tiles) {
			for(int y = (int) Math.max((camera.y / 32 - 5), 0); y < (int) Math.min((camera.y / 32 + 5), height); y++) {
				for(int x = (int) Math.max((camera.x / 32 - 8), 0); x < (int) Math.min((camera.x / 32 + 8), width); x++) {
					if(layer[x+y*width] != null){
						g.drawImage(((ImageResource) ResourceManager.getImageResource(
								layer[x+y*width].getSprite())).getImage(), x * 32, y * 32);
					}
				}
			}
		}
		test.draw(10, 10);
		for(Entity e : entities) {
			e.render(container, game, g);
		}
		
		g.resetTransform();
	}
}
