package fr.eni.bo;

public class Article {

	private Integer id_article;
	private String nom;
	private Integer prix;

	public Article() {

	}

	public Article(String nom, int prix) {
		this.nom = nom;
		this.prix = prix;
	}

	public Article(Integer id_article, String nom, int prix) {
		this.id_article = id_article;
		this.nom = nom;
		this.prix = prix;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getPrix() {
		return prix;
	}

	public void setPrix(Integer prix) {
		this.prix = prix;
	}

	public Integer getId_article() {
		return id_article;
	}

	public void setId_article(Integer id_article) {
		this.id_article = id_article;
	}

	@Override
	public String toString() {
		return "Article [id_article=" + id_article + ", nom=" + nom + ", prix=" + prix + "]";
	}

}
