package org.ittek14.nekoden.gui;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class GUI {
  public ArrayList<Widget> widgets;
  
  public GUI() {
    widgets = new ArrayList<Widget>();
  }
  
  public void update(GameContainer gc, int delta) {
    for(Widget widget : widgets) {
      widget.update(gc, delta);
    }
  }
  
  public void render(GameContainer gc, Graphics g) {
    for(Widget widget : widgets) {
      widget.render(gc, g);
    }
  }

  public void addWidget(Widget widget) {
    widgets.add(widget);
  }
  
  public void clearWidgets(GameContainer container) {
	  for(int i = 0; i < widgets.size(); i++) {
		  widgets.get(i).unregister(container);
		  widgets.get(i).disable();
		  widgets.remove(i);
	  }
  }
}
