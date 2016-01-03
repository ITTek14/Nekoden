package org.ittek14.nekoden.managers;

public abstract class Resource {
	
	public String id;
	
	public Resource() {}
	
	public Resource(String _id) {
		id = _id;
	}
	
	public abstract void loadResource(String path);
}
