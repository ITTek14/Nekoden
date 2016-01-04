package org.ittek14.nekoden.gui;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

public class ProgressBar extends Widget {
	
	private final int maxValue;
	private int value;
	private float maxLength, height, unitLength, length;
	
	private Rectangle shape;
	private Color color = null;
	
	public ProgressBar(GameContainer gc, final int maxValue, float maxLength, float height, Vector2f position) {
		super(gc);
		this.maxValue = maxValue;
		this.maxLength = maxLength;
		this.height = height;
		unitLength = maxLength / maxValue;
		shape = new Rectangle(0f, 0f, 0f, 0f);
		this.position = position;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}

	@Override
	public void update(GameContainer gc, int delta) {
		if(value <= maxValue) {
			length = value * unitLength;
		} else {
			length = maxLength;
		}
		shape.setX(position.x);
		shape.setY(position.y);
		shape.setSize(length, height);
	}

	@Override
	public void render(GameContainer gc, Graphics g) {
		if(color != null) {
			g.setColor(color);
		}
		g.fill(shape);
	}

	public void setPosition(float x, float y) {
		position = new Vector2f(x, y);
	}

	public int getMaxValue() {
		return maxValue;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
