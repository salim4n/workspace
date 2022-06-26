package fr.eni.battle;

public class Warrior {
	
	
	int health;
	private int maxDamage;
	private String name;
	 boolean death = false;
	

	
	
	public Warrior(int health, int maxDamage, String name, boolean death) {
		this.health = health;
		this.maxDamage = maxDamage;
		this.name = name;
		this.death = death;
	}

	@Override
	public String toString() {
		return "Warrior [health= " + health + ", maxDamage= " + maxDamage + ", name= " + name + "]";
	}
	
	public  void attack() {
		int i;
		i = (int) (5 + Math.random() * maxDamage);
		this.health -= i;
	}
	


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getDamage() {
		return maxDamage;
	}


	public void setDamage(int damage) {
		this.maxDamage = damage;
	}


	public double getHealth() {
		return health;
	}


	public void setHealth(int health) {
		this.health = health;
	}

	public boolean isDeath() {
		return death;
	}

	public void setDeath(boolean death) {
		this.death = death;
	}
	

}
