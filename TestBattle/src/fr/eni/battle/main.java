package fr.eni.battle;

public class main {

	public static void main(String[] args) {

		Warrior hannibal = new Warrior(200, 25, "hannibal", false);
		Warrior scipion = new Warrior(200, 25, "scipion", false);

		System.out.printf("%s%n%s%n", hannibal, scipion);

		System.out.println("La bagarre commence !!!!");

		do {
			int alea = (int) (Math.random() * 4);
			if (alea == 1) {
				hannibal.attack();
				System.out.println("scipion porte un coup a hannibal !!!");
				System.out.println("hannibal sante : " + hannibal.health);
			} else if (alea == 2) {
				scipion.attack();
				System.out.println("hannibal porte un coup a scipion!!!");
				System.out.println(" scipion sante : " + scipion.health);
			} else if (alea == 3) {
				System.out.println("shlink shlonk  !!! c'est le bruit du fer qui s'entrecroise !!!!");
			}

			if (hannibal.health <= 0) {
				hannibal.death = true;
				System.out.println("Hannibal est tombe au combat !");
			} else {
				hannibal.death = false;
			}

			if (scipion.health <= 0) {
				scipion.death = true;
				System.out.println("Scipion est tombe au combat !");
			} else {
				scipion.death = false;
			}
		} while (hannibal.isDeath() == false && scipion.isDeath() == false);

		System.out.printf("%s%n%s%n", hannibal, scipion);

	}
}
