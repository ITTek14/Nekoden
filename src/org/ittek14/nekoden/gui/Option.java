package org.ittek14.nekoden.gui;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Option extends Widget {
  protected String text;
  protected int[] mouseButtons;
  
  public Option(GameContainer gc, Select select, String text) {
    super(gc);
    this.text = text;
  }
  
  public void onSelected(){};
  

  public String getText() {
    return text;
  }
  
  @Override
  public void update(GameContainer gc, int delta) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void render(GameContainer gc, Graphics g) {
    
  }
}
