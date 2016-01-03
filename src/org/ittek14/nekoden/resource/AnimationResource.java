package org.ittek14.nekoden.resource;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;

public class AnimationResource extends Resource {
	private Image[] frames;
	private int speed;
	private boolean pingPong;
	
	public AnimationResource(String id, int speed, boolean pingPong) {
		super(id);
		this.speed = speed;
		this.pingPong = pingPong;
	}
	
	public void loadFrames(String[] sprites){
		frames = new Image[sprites.length];
		for(int i = 0; i < frames.length; i++) {
			frames[i] = ResourceManager.getImageResource(sprites[i]).getImage();
		}
	}
	
	public Animation getAnimation() {
		Animation animation = new Animation(frames, speed);
		animation.setPingPong(pingPong);
		return animation;
	}
}
