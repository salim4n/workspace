package fr.eni.test.exceptions;

public class Heros extends Personnage {
	
	
	public Heros(String nom, Armure armure) {
		super(nom, 150, 125, true);
		this.arme = (ComportementArme) new Epee();
		this.armure = armure;
	}
	
	
	public Heros() {
		
	}


	@Override
	public void combattre(Personnage adversaire) {
		System.out.printf("%n%s attaque !!%n",this.getNom());
		adversaire.setSante(adversaire.getSante() - this.arme.horizontal());
		System.out.printf("%n%s %n%s",this.toString(),adversaire.toString());
		
	}


	@Override
	public String toString() {
		return "Heros [arme=" + arme + ", nom=" + nom + ", sante=" + sante + ", endurance=" + endurance + ", alive="
				+ alive + "]";
	}



		

		
	


	
}
