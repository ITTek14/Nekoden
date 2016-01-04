package org.ittek14.nekoden.gui;

import org.ittek14.nekoden.Settings;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;

public class DialogBox extends Widget {
	protected String text="";
	protected float progress;
	
	public DialogBox(GameContainer gc, String text) {
		super(gc);
		this.text = text;
		this.progress = 0;
	}

	@Override
	public void update(GameContainer gc, int delta) {
		progress += delta;
	}

	@Override
	public void render(GameContainer gc, Graphics g) {
		g.setColor(Color.red);
		g.setFont(gc.getDefaultFont());
		Vector2f metaCoords = Settings.toMetaCoordinates(new Vector2f(g.getFont().getWidth(text) / Settings.getScale(), 100));
		g.drawString(text, metaCoords.getX(), metaCoords.getY());
	}
	
}
