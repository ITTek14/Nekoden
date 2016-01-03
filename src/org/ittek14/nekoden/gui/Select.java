// list with selectable options
package org.ittek14.nekoden.gui;

import java.util.ArrayList;

import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;


public class Select extends Widget {
  protected ArrayList<Option> options;
  protected int selected;
  protected Font font;
  protected int marginSize;
  protected Vector2f size;
  
  public Select(GameContainer gc) {
    super(gc);
    selected = -1;
    marginSize = 16;
    font = gc.getDefaultFont();
  }
  
  public void select(Option option) {
    if(options.contains(option)) {
      selected = options.indexOf(option);
    }
  }
  
  public void updateSize() {
    
  }

  public Option getSelected() {
    if(selected >= 0 && selected < options.size()) {
      return options.get(selected);
    } 
    return null;
  }
  
  public void addOption(Option option) {
    options.add(option);
  }
  
  @Override
  public void mousePressed(int button, int x, int y) {
    if(button == 0 || button == 1)
    {
      if(new Rectangle(position.getX(), position.getY(), marginSize * 2 + font.getWidth("Banus"), marginSize).contains(x, y))
      {
        
      }
    }
  }
  
  @Override
  public void update(GameContainer gc, int delta) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void render(GameContainer gc, Graphics g) {
    // TODO Auto-generated method stub
    
  }
  
}
