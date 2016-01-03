package org.ittek14.nekoden.graphics;

import org.ittek14.nekoden.resource.AnimationResource;
import org.ittek14.nekoden.resource.ImageResource;
import org.ittek14.nekoden.resource.Resource;
import org.ittek14.nekoden.resource.ResourceManager;
import org.newdawn.slick.Animation;

public class Sprite {
	private Animation animation;
	
	public Sprite(String resource) {
		Resource res = ResourceManager.getResource(resource);
		if(res.getClass() == ImageResource.class){
			animation = new Animation();
			animation.addFrame(((ImageResource) res).getImage(), 1000);
		}else if(res.getClass() == AnimationResource.class){
			animation = ((AnimationResource) res).getAnimation();
		} 
	}

	public void draw(float x, float y) {
		animation.draw(x, y);
	}
}
