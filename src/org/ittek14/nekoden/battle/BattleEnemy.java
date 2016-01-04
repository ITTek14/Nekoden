package org.ittek14.nekoden.battle;

import org.ittek14.nekoden.entity.Entity;
import org.newdawn.slick.geom.Vector2f;

public abstract class BattleEnemy extends Entity {
	
	private String name;
	private EntityBattleData data;
	
	public BattleEnemy(String name, EntityBattleData data) {
		super();
		this.name = name;
		this.data = data;
	}
	
	public BattleEnemy(Vector2f position, String name, EntityBattleData data) {
		super(position);
		this.name = name;
		this.data = data;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public EntityBattleData getBattleData() {
		return data;
	}
	
	public void setBattleData(EntityBattleData data) {
		this.data = data;
	}
	
	public boolean isDead() {
		return data.isDead();
	}
}
