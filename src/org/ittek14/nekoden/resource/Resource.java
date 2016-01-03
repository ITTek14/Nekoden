package org.ittek14.nekoden.resource;

public abstract class Resource {
	
	private String id;
	
	public Resource(String _id) {
		id = _id;
	}
	
	public String getID(){ 
		return id;
	}
	
	public abstract void loadResource(String ref);
}
