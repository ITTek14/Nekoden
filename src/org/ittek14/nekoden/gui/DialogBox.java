package org.ittek14.nekoden.gui;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

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
		g.drawString(text, 5, 270 - g.getFont().getHeight(text)/6 - 5);
	}
	
}
