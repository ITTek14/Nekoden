package org.ittek14.nekoden.battle;

public class EntityBattleData {
	
	private int healthPoints;
	private int magicPoints;
	
	public EntityBattleData(int healthPoints, int magicPoints) {
		this.healthPoints = healthPoints;
		this.magicPoints = magicPoints;
	}
	
	public int getHP() {
		return healthPoints;
	}
	
	public int getMP() {
		return magicPoints;
	}
	
	public void setHP(int healthPoints) {
		this.healthPoints = healthPoints;
	}
	
	public void setMP(int magicPoints) {
		this.magicPoints = magicPoints;
	}
	
	public void subtractHP(int amount) {
		if(healthPoints - amount >= 0) {
			healthPoints -= amount;
		} else {
			healthPoints = 0;
		}
	}
	
	public void subtractMP(int amount) {
		if(magicPoints - amount >= 0) {
			magicPoints -= amount;
		} else {
			magicPoints = 0;
		}
	}
	
	public void addHP(int amount) {
		healthPoints += amount;
	}
	
	public void addMP(int amount) {
		magicPoints += amount;
	}
	
	public boolean isDead() {
		return healthPoints <= 0;
	}
}
