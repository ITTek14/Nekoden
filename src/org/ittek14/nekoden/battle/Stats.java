package org.ittek14.nekoden.battle;

public class Stats {
	
	private int healthPoints;
	private int magicPoints;
	private int atkPoints;
	
	public Stats(int healthPoints, int magicPoints, int aktPoints) {
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
	
	public void setATK(int atkPoints) {
		this.atkPoints = atkPoints;
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
	
	public void subtractATK(int amount) {
		if(atkPoints - amount >= 0) {
			atkPoints -= amount;
		} else {
			atkPoints = 0;
		}
	}
	
	public void addHP(int amount) {
		healthPoints += amount;
	}
	
	public void addMP(int amount) {
		magicPoints += amount;
	}
	
	public void addATK(int amount) {
		atkPoints += amount;
	}
	
	public boolean isDead() {
		return healthPoints <= 0;
	}
}
