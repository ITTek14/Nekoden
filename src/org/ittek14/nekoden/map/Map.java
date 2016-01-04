package org.ittek14.nekoden.map;

import java.util.ArrayList;
import java.util.Random;

import org.ittek14.nekoden.entity.Entity;
import org.ittek14.nekoden.entity.Player;
import org.ittek14.nekoden.graphics.Camera;
import org.ittek14.nekoden.graphics.Sprite;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

public class Map {
	private int width, height;
	private Camera camera;
	private Tile[][] tiles;
	private ArrayList<Entity> entities = new ArrayList<Entity>();
	private Player player;
	public Map(int w, int h){
		this.width = w; 
		this.height = h;
		tiles = new Tile[3][w*h];
		for(int tile = 0; tile < w*h; tile++) {
			if(new Random().nextBoolean())
				tiles[0][tile] = new Tile(new Sprite("tile_grass"));
			else
				tiles[0][tile] = new Tile(new Sprite("tile_water"));
			
			if(new Random().nextInt(10) == 1 && tiles[0][tile].getSprite().getResourceID().equals("tile_grass")){
				tiles[1][tile] = new Tile(new Sprite("tree_bot"));
				if(tile-w >= 0)
					tiles[2][tile-w] = new Tile(new Sprite("tree_top"));
			}
		}
		player = new Player(new Vector2f(0f, 0f));
		camera = new Camera();
		camera.lockOn(player);
		entities.add(player);
		entities.add(camera);
	}
	
	public void update(GameContainer container, StateBasedGame game, int delta) {
		for(Entity e : entities) {
			e.update(container, game, delta);
		}
	}
	
	public void render(GameContainer container, StateBasedGame game, Graphics g) {
		camera.translateGraphics(container, g);
		
		for(int y = (int) Math.max((camera.getPosition().getY() / 32 - 6), 0); 
				y < (int) Math.min((camera.getPosition().getY() / 32 + 6), height); y++) {
			for(int x = (int) Math.max((camera.getPosition().getX() / 32 - 10), 0); 
					x < (int) Math.min((camera.getPosition().getX() / 32 + 10), width); x++) {
				if(tiles[0][x+y*width] != null) {
					tiles[0][x+y*width].draw(x*32,y*32);
				}
				if(tiles[1][x+y*width] != null) {
					tiles[1][x+y*width].draw(x*32,y*32);
				}
			}
		}
		for(Entity e : entities) {
			e.draw();
		}
		for(int y = (int) Math.max((camera.getPosition().getY() / 32 - 6), 0); 
				y < (int) Math.min((camera.getPosition().getY() / 32 + 6), height); y++) {
			for(int x = (int) Math.max((camera.getPosition().getX() / 32 - 10), 0); 
					x < (int) Math.min((camera.getPosition().getX() / 32 + 10), width); x++) {
				if(tiles[2][x+y*width] != null) {
					tiles[2][x+y*width].draw(x*32,y*32);
				}
			}
		}
		g.resetTransform();
	}
}
