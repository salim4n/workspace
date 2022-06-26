package fr.eni.test.heritage;

import java.util.Scanner;

public class Guerrier extends Humains   {

	protected int degatMax;
	protected int sante;
	protected comportementArme arme;

	public Guerrier(String name, int degatMax, int sante) {
		super(name);
		this.degatMax = degatMax;
		this.sante = sante;
		this.arme = new Arme();
	}

	public Guerrier(String name) {
		super(name);
	}

	public Guerrier() {
		super();
	}

	public void combatJ(Guerrier adversaire) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n a votre tour d'attaquer !!!\n" + "que voulez vous faire?\n" + "1-attaque horizontal\n"
				+ "2-attaque lateral\n" + "3-attaque d'estoc\n" + "4-attaque de rage\n");
		int choix = sc.nextInt();
		switch (choix) {
		case 1:
			adversaire.setSante(adversaire.getSante() - this.arme.horizontal());
			System.out.printf("%n%s envoie une attaque horizontal sur %s !!!%n", this.getName(), adversaire.name);
			break;
		case 2:
			adversaire.setSante(adversaire.getSante() - this.arme.lateral());
			System.out.printf("%n%s attaque en estoc %s !!!%n", this.getName(), adversaire.name);
			break;
		case 3:
			adversaire.setSante(adversaire.getSante() - this.arme.estoc());
			System.out.printf("%n%s envoie une attaque lateral sur %s !!!%n", this.getName(), adversaire.name);
			break;
		case 4:
			int j = (int) (Math.random() * 2);
			if (j == 1) {
				adversaire.setSante(adversaire.getSante() - this.arme.rage());
				System.out.printf(
						"%n%s envoie un coup surpuissant de toutes ses forces sur %s !!! C'est un veritable carnage !!!!%n",
						this.getName(), adversaire.name);
			} else if (j == 2) {
				System.out.printf("%n%s rate son attaque sur %s%n", this.getName(), adversaire.name);
			} else {
				System.out.println("ya un bug mec");
			}
			
			break;
		default:
			System.out.printf("%n%s prend du recul sur la situation",this.getName());
			break;
		}
		if (this.sante <= 0 || adversaire.sante <= 0) {
			sc.close();
		}

		System.out.printf("%n%s %n%s", this.toString(), adversaire.toString());

	}

	public void combattre(Guerrier adversaire) {

		int i = (int) (Math.random() * 5);
		switch (i) {
		case 1:
			adversaire.setSante(adversaire.getSante() - this.arme.horizontal());
			System.out.printf("%n%s envoie une attaque horizontal sur %s !!!%n", this.getName(), adversaire.name);
			break;
		case 2:
			adversaire.setSante(adversaire.getSante() - this.arme.estoc());
			System.out.printf("%n%s attaque en estoc %s !!!%n", this.getName(), adversaire.name);
			break;
		case 3:
			adversaire.setSante(adversaire.getSante() - this.arme.lateral());
			System.out.printf("%n%s envoie une attaque lateral sur %s !!!%n", this.getName(), adversaire.name);
			break;
		case 4:
			int j = (int) (Math.random() * 2);
			if (j == 1) {
				adversaire.setSante(adversaire.getSante() - this.arme.rage());
				System.out.printf(
						"%n%s envoie un coup surpuissant de toutes ses forces sur %s !!! C'est un veritable carnage !!!!%n",
						this.getName(), adversaire.name);
			} else if (j == 2) {
				System.out.printf("%n%s rate son attaque sur %s%n", this.getName(), adversaire.name);
			}

			break;
		default:
			System.out.println("Les deux se regardent et prepare leurs attaques");
			break;
		}
		System.out.printf("%n%s %n%s", this.toString(), adversaire.toString());

	}

	public int getDegatMax() {
		return degatMax;
	}

	public void setDegatMax(int degatMax) {
		this.degatMax = degatMax;
	}

	public int getSante() {
		return sante;
	}

	public void setSante(int sante) {
		this.sante = sante;
	}

	public comportementArme getArme() {
		return arme;
	}

	public void setArme(comportementArme arme) {
		this.arme = arme;
	}

}
