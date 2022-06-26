package fr.eni.test.heritage;

import java.util.ArrayList;
import java.util.List;

public class Lanniste extends Humains {
	
	 protected int monnaie;
	 protected List<Guerrier>ludus;	
	 
	 public Lanniste() {
		 
	 }
	 
	 public Lanniste(String name, int monnaie, List<Guerrier>ludus) {
		 super(name);
		 this.monnaie = monnaie;
		 ludus = new ArrayList<>();
		 
	 }
	 
	 public Lanniste(String name) {
		 super(name);
	 }

	public int getMonnaie() {
		return monnaie;
	}

	public void setMonnaie(int monnaie) {
		this.monnaie = monnaie;
	}

	public List<Guerrier> getLudus() {
		return ludus;
	}

	public void setLudus(List<Guerrier> ludus) {
		this.ludus = ludus;
	}

	@Override
	public String toString() {
		return "Lanniste [monnaie=" + monnaie + ", ludus=" + ludus + "]";
	}
	 
	 
	
	

}
