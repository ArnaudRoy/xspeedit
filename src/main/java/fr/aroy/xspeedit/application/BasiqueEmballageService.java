package fr.aroy.xspeedit.application;

import java.util.List;

import fr.aroy.xspeedit.domain.Article;
import fr.aroy.xspeedit.domain.Carton;
import fr.aroy.xspeedit.domain.EspaceDeStockage;
import fr.aroy.xspeedit.domain.EspaceDeStockageRepository;

/**
 * Implémentation basique du service d'emballage
 * Prend les articles les uns après les autres, et les mets dans un carton.
 * Si la taille totale dépasse la contenance du carton, le robot met l'article dans le carton suivant.
 * @author royar
 *
 */
public class BasiqueEmballageService implements EmballageService {
	
	/** Repo de l'espace de stockage */
	EspaceDeStockageRepository espaceDeStockageRepository; 

	/** Constructeur */
	public BasiqueEmballageService() {
	}
	
	/** Constructeur avec le repo */
	public BasiqueEmballageService(EspaceDeStockageRepository espaceDeStockageRepository) {
		this.espaceDeStockageRepository = espaceDeStockageRepository;
	}
	
	@Override
	public void emballer(Article[] chaineDArticles) {
		EspaceDeStockage espaceDeStockage = espaceDeStockageRepository.loadEspaceDeStockage();
		
		Carton carton;
		
		List<Carton> chaineDeCartons = espaceDeStockage.getChaineDeCartons();
		if (chaineDeCartons.size() > 0) {
			carton = chaineDeCartons.get(chaineDeCartons.size() - 1);
		} else {
			carton = new Carton();
			chaineDeCartons.add(carton);
		}
		for (Article article : chaineDArticles) {
			if (carton.getCapaciteRestante() < article.taille) {
				carton = new Carton();
				chaineDeCartons.add(carton);
			}
			carton.addArticle(article);
		}
	}

	@Override
	public Carton[] getCartonsALivrer() {
		EspaceDeStockage espaceDeStockage = espaceDeStockageRepository.loadEspaceDeStockage();
		return espaceDeStockage.getChaineDeCartons().stream().toArray(size -> new Carton[size]);
	}
	
	/**
	 * Setter du repo
	 * @param espaceDeStockageRepository
	 */
	public void setEspaceDeStockageRepository(EspaceDeStockageRepository espaceDeStockageRepository) {
		this.espaceDeStockageRepository = espaceDeStockageRepository;
	}

}
