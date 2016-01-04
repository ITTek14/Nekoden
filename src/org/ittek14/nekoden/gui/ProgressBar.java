package org.ittek14.nekoden.gui;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

public class ProgressBar extends Widget {
	
	private int maxValue, value;
	private float maxLength, width, unitLength, length;
	private Vector2f size;
	
	private Rectangle shape;
	
	public ProgressBar(GameContainer gc, int maxValue, float maxLength, float width, Vector2f position) {
		super(gc);
		this.maxValue = maxValue;
		this.maxLength = maxLength;
		this.width = width;
		unitLength = maxLength / maxValue;
		shape = new Rectangle(0f, 0f, 0f, 0f);
		this.position = position;
	}

	@Override
	public void update(GameContainer gc, int delta) {
		if(value <= maxValue) {
			length = value * unitLength;
		} else {
			length = maxLength;
		}
	}

	@Override
	public void render(GameContainer gc, Graphics g) {
		g.draw(shape);
	}

}
