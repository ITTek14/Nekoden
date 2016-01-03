package org.ittek14.nekoden.resource;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.util.xml.XMLElement;
import org.newdawn.slick.util.xml.XMLElementList;
import org.newdawn.slick.util.xml.XMLParser;

public class ResourceManager {
	public static ArrayList<ImageResource> imageResources = new ArrayList<ImageResource>();
	public static ArrayList<AudioResource> audioResources = new ArrayList<AudioResource>();
	
	public static void loadResourcePack(String path) {
		XMLParser parser = new XMLParser();
		XMLElement origin;
		try {
			origin = parser.parse(path);
			XMLElementList imgElements = origin.getChildrenByName("IMG");
			for(int i = 0; i < imgElements.size(); i++) {
				ImageResource imgRes = new ImageResource(imgElements.get(i).getAttribute("id"));
				imgRes.loadResource(imgElements.get(i).getAttribute("path"));
				imageResources.add(imgRes);
			}
			
			XMLElementList spriteSheetElements = origin.getChildrenByName("SpriteSheet");
			for(int i = 0; i < spriteSheetElements.size(); i++) {
				Image img = new Image(spriteSheetElements.get(i).getAttribute("path"));
				img.setFilter(Image.FILTER_NEAREST);
				SpriteSheet spriteSheet = new SpriteSheet(img, 1, 1);
				XMLElementList spriteElements = spriteSheetElements.get(i).getChildrenByName("Sprite");

				for(int j = 0; j < spriteElements.size(); j++) {
					XMLElement sprite = spriteElements.get(j);
					ImageResource imgRes = new ImageResource(spriteElements.get(i).getAttribute("id"));
					imgRes.setImage(spriteSheet.getSubImage(
							sprite.getIntAttribute("x"), sprite.getIntAttribute("y")
							, sprite.getIntAttribute("w"), sprite.getIntAttribute("h")));
					imageResources.add(imgRes);
				}
			}

			XMLElementList audElements = origin.getChildrenByName("Audio");
			for(int i = 0; i < audElements.size(); i++) {
				AudioResource audRes = new AudioResource(audElements.get(i).getAttribute("id"));
				audRes.loadResource(audElements.get(i).getAttribute("path"));
				audioResources.add(audRes);
			}
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public static ImageResource getImageResource(String id) {
		for(ImageResource resource : imageResources) {
			if(resource.getID().equals(id)) {
				return resource;
			}
		}
		return null;
	}
	
	public static AudioResource getAudioResource(String id) {
		for(AudioResource resource : audioResources) {
			if(resource.getID() == id) {
				return resource;
			}
		}
		return null;
	}
	
	public static Resource getResource(String id) {
		for(Resource resource : imageResources) {
			if(resource.getID() == id) {
				return resource;
			}
		}
		for(Resource resource : audioResources) {
			if(resource.getID() == id) {
				return resource;
			}
		}
		return null;
	}
}