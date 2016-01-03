package org.ittek14.nekoden.resource;

import java.util.ArrayList;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.util.xml.XMLElement;
import org.newdawn.slick.util.xml.XMLElementList;
import org.newdawn.slick.util.xml.XMLParser;

public class ResourceManager {
	
	public static ArrayList<Resource> resources = new ArrayList<>();
	
	static {
		resources.add(new ImageResource("resources/sprite.png"));
	}
	
	public static void loadResourcePack(String path) {
		XMLParser parser = new XMLParser();
		XMLElement origin;
		try {
			origin = parser.parse(path);
			XMLElementList imgElements = origin.getChildrenByName("IMG");
			for(int i = 0; i < imgElements.size(); i++) {
				ImageResource res = new ImageResource(imgElements.get(i).getAttribute("id"));
			}
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public static Resource getResource(String id) {
		for(Resource resource : resources) {
			if(resource.getID() == id) {
				return resource;
			}
		}
		return null;
	}
}