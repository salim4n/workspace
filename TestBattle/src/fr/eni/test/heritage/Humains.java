package fr.eni.test.heritage;

public abstract class Humains {

	protected String name;

	public Humains(String name) {
		this.name = name;
	}

	public Humains() {

	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Humains [name=" + name + "]";
	}

	public void setName(String name) {
		this.name = name;
	}

	public void combattre(Guerrier adversaire) {

	}

}
