package fr.eni.ecole.quelMedecin.test;

public class Adresse  {
	
	private String mentions;
	private String rue;
	private int numero;
	private String complNumero;
	private int cp;
	private String ville;
	private MedecinGeneraliste MedecinGeneraliste;
	
	
	public Adresse(String mentions, int numero, String complNumero, String rue, int cp, String ville) {
		this.mentions = mentions;
		this.numero = numero;
		this.complNumero = complNumero;
		this.rue = rue;
		this.cp = cp;
		this.ville = ville;

	}
	
	public Adresse( int numero, String complNumero, String rue, int cp, String ville) {
		this(null,numero,complNumero,rue,cp,ville);
	}

	
	public void afficher() {
		if (this.mentions != null)
			System.out.println(mentions);
		System.out.printf("%d%s %s%n%05d %s%n",
				this.numero,
				this.complNumero != null ? this.complNumero : "",
						this.rue,
						this.cp,
						this.ville);
	}

	public MedecinGeneraliste getMedecinGeneraliste() {
		return MedecinGeneraliste;
	}
	
	
	
	

}
