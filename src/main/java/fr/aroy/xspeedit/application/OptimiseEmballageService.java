package fr.aroy.xspeedit.application;

import java.util.List;

import fr.aroy.xspeedit.domain.Article;
import fr.aroy.xspeedit.domain.Carton;
import fr.aroy.xspeedit.domain.EspaceDeStockage;
import fr.aroy.xspeedit.domain.EspaceDeStockageRepository;

/**
 * Implémentation optimisée du service d'emballage
 * Prend les articles les uns après les autres, et verifie chaque carton pour trouver un carton avec de la place.
 * Si aucun carton n'a la capacité suffisante, le robot met l'article dans un nouveau carton.
 * @author royar
 *
 */
public class OptimiseEmballageService implements EmballageService {
	
	/** Repo de l'espace de stockage */
	EspaceDeStockageRepository espaceDeStockageRepository; 

	/** Constructeur */
	public OptimiseEmballageService() {
	}
	
	/** Constructeur avec le repo */
	public OptimiseEmballageService(EspaceDeStockageRepository espaceDeStockageRepository) {
		this.espaceDeStockageRepository = espaceDeStockageRepository;
	}
	

	@Override
	public void emballer(Article[] chaineDArticles) {
		EspaceDeStockage espaceDeStockage = espaceDeStockageRepository.loadEspaceDeStockage();
		
		List<Carton> chaineDeCartons = espaceDeStockage.getChaineDeCartons();
		if (chaineDeCartons.size() == 0) {
			chaineDeCartons.add(new Carton());
		}
		
		for (Article article : chaineDArticles) {
			boolean isArticleEmballe = false;
			for (Carton carton : chaineDeCartons) {
				if (carton.getCapaciteRestante() >= article.taille) {
					carton.addArticle(article);
					isArticleEmballe = true;
					break;
				}
			}
			if (!isArticleEmballe) {
				Carton carton = new Carton();
				chaineDeCartons.add(carton);
				carton.addArticle(article);
			}
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
