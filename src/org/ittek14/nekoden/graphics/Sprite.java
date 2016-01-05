package org.ittek14.nekoden.graphics;

import org.ittek14.nekoden.resource.AnimationResource;
import org.ittek14.nekoden.resource.ImageResource;
import org.ittek14.nekoden.resource.Resource;
import org.ittek14.nekoden.resource.ResourceManager;
import org.newdawn.slick.Animation;

public class Sprite {
	private Animation animation;
	private String id;
	private boolean loop = true;
	
	public Sprite(String resource) {
		id = resource;
		Resource res = ResourceManager.getResource(resource);
		if(res.getClass() == ImageResource.class){
			animation = new Animation();
			animation.addFrame(((ImageResource) res).getImage(), 1000);
		}else if(res.getClass() == AnimationResource.class){
			animation = ((AnimationResource) res).getAnimation();
		} 
	}
	
	public void setLoop(boolean loop) {
		this.loop = loop;
		if(!loop)
			animation.setCurrentFrame(animation.getFrameCount() - 1);
	}
	
	public boolean getLoop() {
		return loop;
	}
	
	public String getResourceID() {
		return id;
	}

	public boolean isFinished() {
		return animation.getFrame() == animation.getFrameCount() - 1;
	}
	
	public void play() {
		animation.restart();
	}
	
	public void draw(float x, float y) {
		animation.draw(x, y);
	}
}
