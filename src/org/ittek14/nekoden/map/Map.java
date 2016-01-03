package org.ittek14.nekoden.map;

public class Map {
	public int width, height;
	public Tile[][] tiles;
	
	public Map(int w, int h){
		this.width = w; 
		this.height = h;
		tiles = new Tile[3][w*h];
	}
}
