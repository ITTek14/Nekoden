package org.ittek14.nekoden.map;

import org.ittek14.nekoden.battle.Stats;
import org.ittek14.nekoden.entity.Player;
import org.ittek14.nekoden.gui.DialogBox;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;

public class TestMap extends Map {
	private Player player;

	public TestMap(GameContainer gc) {
		super(gc);
		loadTiles("test.map");
		player = new Player(new Vector2f(0f, 0f));
		camera.lockOn(player);
		entities.add(player);
		entities.add(camera);
		gui.addWidget(new DialogBox(gc, "HAHAHA, YOU WILL NEVER\nFIND THE SECRET MATTEFÅRMEL!"));
	}
}
