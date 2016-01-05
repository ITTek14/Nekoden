package org.ittek14.nekoden.map;

import java.util.ArrayList;

import org.ittek14.nekoden.entity.Entity;
import org.ittek14.nekoden.graphics.Camera;
import org.ittek14.nekoden.graphics.Sprite;
import org.ittek14.nekoden.gui.GUI;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.xml.XMLElement;
import org.newdawn.slick.util.xml.XMLElementList;
import org.newdawn.slick.util.xml.XMLParser;

public abstract class Map {
	protected GUI gui;
	protected int width, height;
	protected Camera camera;
	protected Tile[][] tiles;
	protected ArrayList<Entity> entities = new ArrayList<Entity>();
	
	public Map (GameContainer gc) {
		gui = new GUI();
		camera = new Camera();
	}
	
	public void loadTiles(String path){
		XMLParser parser = new XMLParser();
		try {
			XMLElement mapElement = parser.parse(path);
			width = mapElement.getIntAttribute("width");
			height = mapElement.getIntAttribute("height");
			tiles = new Tile[3][width*height];
			
			XMLElementList tileElements = mapElement.getChildrenByName("Tile");
			char[] alias = new char[tileElements.size()];
			String[] ids = new String[tileElements.size()];
			for(int i = 0; i < tileElements.size(); i++) {
				alias[i] = tileElements.get(i).getAttribute("alias").charAt(0);
				ids[i] = tileElements.get(i).getAttribute("graphics");
			}
			
			for(int l = 0; l < 3; l++){
				XMLElementList layerElements = mapElement.getChildrenByName("Layer"+(l+1));
				for(int i = 0; i < layerElements.size(); i++) {
					String data = layerElements.get(i).getContent();
					data = data.replaceAll(" ", "");
					data = data.replaceAll("	", "");
					data = data.replaceAll("\n", "");
					
					for(int y = 0; y < height; y++) {
						for(int x = 0; x < width; x++) {
							for(int t = 0; t < alias.length; t++)
							{
								if(data.charAt(x+y*width) == alias[t]) {
									tiles[l][x+y*width] = new Tile(new Sprite(ids[t], true));
								}
							}
						}
					}
				}
			}
			
		} catch (SlickException e) {
			e.printStackTrace();
		}

	}
	
	public boolean isEmpty(int tile, int layer) {
		return tiles[layer][tile] == null;
	}
	
	public boolean isEmpty(float x, float y, int layer) {
		return tiles[layer][(int) ((x/32)+1+((y/32)+1)*width)] == null;
	}
	
	public void update(GameContainer container, StateBasedGame game, int delta) {
		for(Entity e : entities) {
			e.update(container, game, this, delta);
		}
		gui.update(container, delta);
	}
	
	public void render(GameContainer container, StateBasedGame game, Graphics g) {
		g.pushTransform();
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
		g.popTransform();
		gui.render(container, g);
	}
}
