package fr.aroy.xspeedit.application;

import java.util.Arrays;
import java.util.stream.Stream;

import fr.aroy.xspeedit.domain.Article;
import fr.aroy.xspeedit.domain.Carton;
import fr.aroy.xspeedit.domain.EspaceDeStockage;
import fr.aroy.xspeedit.domain.EspaceDeStockageRepository;

/**
 * Implémentation optimisée du service d'emballage
 * Prend les articles les uns après les autres en ordre decroissant de taille, et verifie chaque carton pour trouver un carton avec de la place.
 * Si aucun carton n'a la capacité suffisante, le robot met l'article dans un nouveau carton.
 * @author royar
 *
 */
public class Optimise3EmballageService implements EmballageService {
	
	/** Repo de l'espace de stockage */
	EspaceDeStockageRepository espaceDeStockageRepository; 

	/** Constructeur */
	public Optimise3EmballageService() {
	}
	
	/** Constructeur avec le repo */
	public Optimise3EmballageService(EspaceDeStockageRepository espaceDeStockageRepository) {
		this.espaceDeStockageRepository = espaceDeStockageRepository;
	}
	

	@Override
	public void emballer(Article[] chaineDArticles) {
		EspaceDeStockage espaceDeStockage = espaceDeStockageRepository.loadEspaceDeStockage();
		
		if (espaceDeStockage.size() == 0) {
			espaceDeStockage.add(new Carton());
		}
		
		Stream<Article> articlesStream = Arrays
				.stream(chaineDArticles)
				.sorted((a1, a2) -> a2.getTaille().compareTo(a1.getTaille()));
		
		articlesStream.forEachOrdered(article -> {
			boolean isArticleEmballe = false;
			for (Carton carton : espaceDeStockage) {
				if (carton.getCapaciteRestante() >= article.getTaille()) {
					carton.addArticle(article);
					isArticleEmballe = true;
					break;
				}
			}
			if (!isArticleEmballe) {
				Carton carton = new Carton();
				espaceDeStockage.add(carton);
				carton.addArticle(article);
			}
		});
	}

	@Override
	public Carton[] getCartonsALivrer() {
		EspaceDeStockage espaceDeStockage = espaceDeStockageRepository.loadEspaceDeStockage();
		return espaceDeStockage.stream().toArray(size -> new Carton[size]);
	}
	
	/**
	 * Setter du repo
	 * @param espaceDeStockageRepository
	 */
	public void setEspaceDeStockageRepository(EspaceDeStockageRepository espaceDeStockageRepository) {
		this.espaceDeStockageRepository = espaceDeStockageRepository;
	}

}
