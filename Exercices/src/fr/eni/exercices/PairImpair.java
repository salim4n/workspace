package fr.eni.exercices;

public class PairImpair {

	public static void main(String[] args) {
		
		int nombre= (int)(Math.random()*100);
		
		if (nombre % 2 == 0) {
			System.out.println("c'est un nombre pair : " + nombre);
		} else {
			System.out.println("ce n'est pas un nombre un pair : " + nombre);
		}
		
		if (nombre > 0) {
			System.out.println("positif");
		} else {
			System.out.println("negatif");
		}

	}

}
