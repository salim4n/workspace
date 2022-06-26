package fr.eni.papeterie.ihm.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import fr.eni.papeterie.bll.BLLException;
import fr.eni.papeterie.bll.CatalogueManager;
import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.ihm.observer.ICatalogueObserver;
import fr.eni.papeterie.ihm.view.EcranArticle;

public class ArticleController {

	private EcranArticle ecrArticle;

	// Attributs
	private int indexCatalogue;

	private CatalogueManager mger;

	private List<Article> catalogue;

	/**
	 * Pattern Observer -- Liste des écrans à mettre à jour
	 */
	private List<ICatalogueObserver> lstCatalogueObservers;
	
	/**
	 * Pattern Observer -- associe un nouvel Observer
	 * 
	 * @param observer
	 */
	public void ajouterCatalogueObserver(ICatalogueObserver observer) {
		if (lstCatalogueObservers == null) {
			lstCatalogueObservers = new ArrayList<>();
		}
		lstCatalogueObservers.add(observer);
	}

	// Constructeur
	public ArticleController() {
	}

	private void initData() {
		// Initialisation du catalogue en mémoire
		try {
			mger = CatalogueManager.getInstance();
			catalogue = mger.getCatalogue();
			indexCatalogue = 0;
		} catch (BLLException e) {
			ecrArticle.infoErreur(e.getMessage());
		}
	}

	public void startApp() {
		ecrArticle = new EcranArticle();
		panelButton();
		initData();
		afficherPremierArticle();
		ecrArticle.setVisible(true);
	}

	/**
	 * Méthodes appels BLL
	 */

	public void afficherPremierArticle() {
		if (catalogue.size() > 0) {
			indexCatalogue = 0;
			ecrArticle.afficherArticle(catalogue.get(indexCatalogue));
		} else {
			indexCatalogue = -1;
			ecrArticle.afficherNouveau();
		}

	}

	public void precedent() {
		if (indexCatalogue > 0) {
			indexCatalogue--;
			ecrArticle.afficherArticle(catalogue.get(indexCatalogue));
		}

	}

	public void suivant() {
		if (indexCatalogue < catalogue.size() - 1) {
			indexCatalogue++;
			ecrArticle.afficherArticle(catalogue.get(indexCatalogue));
		}

	}

	public void nouveau() {
		indexCatalogue = catalogue.size();
		ecrArticle.afficherNouveau();
	}

	public void enregistrer() {
		Article articleAffiche = ecrArticle.getArticle();

		try {
			if (articleAffiche.getIdArticle() == null) {
				mger.addArticle(articleAffiche);
				System.out.println("article: " + articleAffiche);
				catalogue.add(articleAffiche);
				ecrArticle.afficherArticle(articleAffiche);
				// Appeler la mise à jour de tous les Observer
				for (ICatalogueObserver observer : lstCatalogueObservers) {
					observer.miseAJourDesDonnees();
				}
				ecrArticle.information("Nouvel article sauvegardé.");
			} else {
				mger.updateArticle(articleAffiche);
				catalogue.set(indexCatalogue, articleAffiche);
				// Appeler la mise à jour de tous les Observer
				for (ICatalogueObserver observer : lstCatalogueObservers) {
					observer.miseAJourDesDonnees();
				}
				ecrArticle.information("Mise à jour effectuée.");
			}
		} catch (BLLException e) {
			ecrArticle.infoErreur(e.getMessage());
		}

	}

	public void supprimer() {

		try {
			int id = catalogue.get(indexCatalogue).getIdArticle();
			mger.removeArticle(id);
			catalogue.remove(indexCatalogue);
			// Appeler la mise à jour de tous les Observer
			for (ICatalogueObserver observer : lstCatalogueObservers) {
				observer.miseAJourDesDonnees();
			}
			ecrArticle.information("Suppression de l'article réalisée.");
			if (indexCatalogue < catalogue.size()) {
				// Afficher l'article suivant
				ecrArticle.afficherArticle(catalogue.get(indexCatalogue));
			} else if (indexCatalogue > 0) {
				indexCatalogue--;
				ecrArticle.afficherArticle(catalogue.get(indexCatalogue));
			} else {
				ecrArticle.afficherNouveau();
			}
		} catch (BLLException e) {
			ecrArticle.infoErreur(e.getMessage());
		}
	}

	public List<Article> getCatalogue() {
		return catalogue;
	}

	public void panelButton() {
		ecrArticle.getBtnPrecedent().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				precedent();
			}

		});

		ecrArticle.getBtnNouveau().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nouveau();
			}

		});

		ecrArticle.getBtnEnregistrer().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				enregistrer();
			}

		});

		ecrArticle.getBtnSupprimer().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				supprimer();
			}

		});

		ecrArticle.getBtnSuivant().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				suivant();
			}

		});
	}
}
