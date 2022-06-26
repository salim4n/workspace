package fr.eni.test.heritage;

public class Arme implements comportementArme {

	int degat;

	@Override
	public int horizontal() {
		return degat = (int) (15 + (Math.random() * 30));

	}

	@Override
	public int lateral() {
		return degat = (int) (10 + (Math.random() * 20));
	}

	@Override
	public int estoc() {
		return degat = (int) (20 + (Math.random() * 40));
	}

	@Override
	public int rage() {
		return degat = (int) (30 + (Math.random() * 60));
	}

	@Override
	public String toString() {
		return "Epee : " + degat + " degats";
	}

}
