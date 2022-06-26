package fr.eni.test.heritage;

public class Gladiateur extends Guerrier {

	public Gladiateur(String name) {
		super(name, 40, 150);

	}

	public Gladiateur() {

	}

	@Override
	public String toString() {
		return String.format(" Gladiateur %s%nsante : %d%n", this.name, this.sante);
	}

}
