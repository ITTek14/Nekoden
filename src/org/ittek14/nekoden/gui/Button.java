package org.ittek14.nekoden.gui;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

public abstract class Button extends Widget {
  protected Font font;
  protected Rectangle bounds;
  protected boolean pressed = false;
  protected String text;
  protected int marginSize;
  protected int[] mouseButtons;
  
  public Button(GameContainer gc, Vector2f position, String text) {
    super(gc, position);
    this.text = text;
    this.font = gc.getDefaultFont();
    marginSize = 16;
    mouseButtons = new int[]{0,1,2};
    bounds = new Rectangle(0, 0, font.getWidth(text) + marginSize*2, font.getHeight(text) + marginSize*2);
    bounds.setCenterX(position.x);
    bounds.setCenterY(position.y);
  }
  
  public abstract void onClick(int button);
  
  @Override
  public void mouseReleased(int button, int x, int y) {
    if(bounds.contains(x, y)){
      onClick(button);
    }
  }

  @Override
  public void update(GameContainer gc, int delta) {
    boolean buttonUnion = false; // are any of the mouse buttons pressed?
    for(int b = 0; b < mouseButtons.length ; b++) {
      buttonUnion = buttonUnion || Mouse.isButtonDown(mouseButtons[b]);
    }
    
    pressed = bounds.contains(Mouse.getX(), gc.getHeight()-Mouse.getY()) && buttonUnion;
  }
  
  @Override
  public void render(GameContainer gc, Graphics g) {
    if(pressed) {
      g.setColor(Color.darkGray);
    }else{
      g.setColor(Color.gray);
    }
    g.fill(bounds);
    
    font.drawString(position.getX() - font.getWidth(text)/2, position.getY() - font.getHeight(text)/2, text);
  }
}
