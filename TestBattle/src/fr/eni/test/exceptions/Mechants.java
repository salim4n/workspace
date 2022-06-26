package fr.eni.test.exceptions;

public class Mechants extends Personnage {

	public Mechants(String nom, Armure armure) {
		super(nom, 150, 125, true);
		this.arme = new Epee();
		this.armure = armure;
	}
	
	public Mechants() {
		
	}

	@Override
	public void combattre(Personnage adversaire) {
		System.out.printf("%n%s attaque !!%n",this.getNom());
		adversaire.setSante(adversaire.getSante() - this.arme.horizontal()- adversaire.armure.getAbsorptionDegat());
		System.out.printf("%n%s %n%s",this.toString(),adversaire.toString());		
	}

	@Override
	public String toString() {
		return "Mechants [arme=" + arme + ", nom=" + nom + ", sante=" + sante + ", endurance=" + endurance + ", alive="
				+ alive + "]";
	}



}
