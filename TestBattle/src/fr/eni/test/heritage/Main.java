package fr.eni.test.heritage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

	static List<Gladiateur> ludus = new ArrayList<>();

	public static void ajouterGlad(String pseudo) {
		ludus.add(new Gladiateur(pseudo));
	}

	public static Guerrier guerrier1 = new Guerrier();
	public static Guerrier guerrier2 = new Guerrier();

	public static void joueurVsIa() {

		 while (guerrier1.sante > 0 && guerrier2.sante > 0);
			guerrier1.combatJ(guerrier2);
			guerrier2.combattre(guerrier1);

			if (guerrier1.sante <= 0) {
				System.out.printf("%n%s est tombe dans l'arene, il ne se relevera jamais.%n%s est victorieux%n",
						guerrier1.name, guerrier2.name);
			} else if (guerrier2.sante <= 0) {
				System.out.printf("%n%s est tombe dans l'arene, il ne se relevera jamais.%n%s est victorieux%n",
						guerrier2.name, guerrier1.name);
			}

		} 
	

	public static void iaVsIa() {

		do {
			int i = (int) (Math.random() * 3);
			if (i == 1) {
				guerrier1.combattre(guerrier2);
			} else if (i == 2) {
				guerrier2.combattre(guerrier1);
			}

			if (guerrier1.sante <= 0) {
				System.out.printf("%n%s est tombe dans l'arene, il ne se relevera jamais.%n%s est victorieux%n",
						guerrier1.name, guerrier2.name);
			} else if (guerrier2.sante <= 0) {
				System.out.printf("%n%s est tombe dans l'arene, il ne se relevera jamais.%n%s est victorieux%n",
						guerrier2.name, guerrier1.name);
			}

		} while (guerrier1.sante > 0 && guerrier2.sante > 0);
	}

	public static void main(String[] args) {

		ajouterGlad("Commode");
		ajouterGlad("Spartacus");
		ajouterGlad("Oenomaus");
		ajouterGlad("Crixus");
		ajouterGlad("Gannicus");
		ajouterGlad("Maximus");

		System.out.println("Bienvenue a tous dans l'arene de combat");
		System.out.println("------------------------------------------");

		do {
			int j = (int) (Math.random() * ludus.size());
			guerrier1 = ludus.get(j);
			j = (int) (Math.random() * ludus.size());
			guerrier2 = ludus.get(j);
		} while (guerrier1 == guerrier2);
		System.out.printf("Les combattants seront :%n%n%s%n%s%n", guerrier1, guerrier2);

		ArrayList<Date> dates = new ArrayList<>();
		dates.add(new Date());
		for (Date date : dates) {
			System.out.println(date);
		}
		System.out.printf("%nCe combat opposera %s a %s !!%n%n", guerrier1.getName(), guerrier2.getName());

		joueurVsIa();

	}
}
