package fr.eni.coucheBO;

public class Aliment {

	private String nom;
	private Integer id_aliment;

	public Aliment(Integer id_aliment, String nom) {
		this.setId_aliment(id_aliment);
		this.nom = nom;
	}

	public Aliment(String nom) {
		this.nom = nom;
	}

	public Aliment() {

	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getId_aliment() {
		return id_aliment;
	}

	public void setId_aliment(Integer id_aliment) {
		this.id_aliment = id_aliment;
	}

	@Override
	public String toString() {
		return "Aliment [nom=" + nom + ", id_aliment=" + id_aliment + "]";
	}

}
