package fr.eni.test.exceptions;

public abstract class Personnage   {
	
	protected ComportementArme arme;
	protected Armure armure;
	
	protected String nom;
	protected static int sante;
	protected int endurance;
	protected boolean alive;
	
	public Personnage( String nom,int sante, int endurance, boolean alive) {
		
		this.nom = nom;
		this.setSante(sante);
		this.setEndurance(endurance);
		this.alive = alive;
		this.arme = new Epee();
		this.armure = armure;
	}
	
	public Personnage() {
		
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}


	public int getSante() {
		return sante;
	}


	public void setSante(int sante) {
		this.sante = sante;
	}


	public int getEndurance() {
		return endurance;
	}


	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}

	public abstract void combattre(Personnage adversaire);

	
	
}
