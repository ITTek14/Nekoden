package org.ittek14.nekoden.battle;

public class Stats {
	
	private int healthPoints;
	private int magicPoints;
	private int atkPoints;
	
	public Stats(int healthPoints, int magicPoints, int atkPoints) {
		this.healthPoints = healthPoints;
		this.magicPoints = magicPoints;
		this.atkPoints = atkPoints;
	}
	
	public int getHP() {
		return healthPoints;
	}
	
	public int getMP() {
		return magicPoints;
	}
	
	public int getATK() {
		return atkPoints;
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
		healthPoints = Math.max(0, healthPoints-amount);
	}
	
	public void subtractMP(int amount) {
		magicPoints = Math.max(0, magicPoints-amount);
	}
	
	public void subtractATK(int amount) {
		healthPoints = Math.max(0, healthPoints-amount);
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
