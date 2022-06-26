package fr.eni.test.exceptions;

public class Main {

	public static void main(String[] args) {
		
		Heros hero = new Heros("Liham");
		Mechants bad = new Mechants("Bastor");
		
		hero.combattre(bad);
		bad.combattre(hero);
		hero.combattre(bad);

	}

}
