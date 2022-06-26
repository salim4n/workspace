package fr.eni.test.exceptions;

public class Epee implements ComportementArme {

	int degat;
	int min = 20;

	@Override
	public int horizontal() {
		return degat = (int)( Math.random() * 30);
		
		
	}

	@Override
	public int lateral() {
		return degat = (int) ( Math.random() * 20);
		
	}

	@Override
	public int estoc() {
		return degat = (int) (Math.random() * 30);

	}

	@Override
	public int rage() {
		return degat = (int)( Math.random() * 60);
		
	}



	@Override
	public String toString() {
		return "Epee [degat=" + degat + "]";
	}

}
