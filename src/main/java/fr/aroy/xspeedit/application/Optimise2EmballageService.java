package fr.aroy.xspeedit.application;

import java.util.Arrays;
import java.util.List;

import fr.aroy.xspeedit.domain.Article;
import fr.aroy.xspeedit.domain.Carton;
import fr.aroy.xspeedit.domain.EspaceDeStockage;
import fr.aroy.xspeedit.domain.EspaceDeStockageRepository;
import fr.aroy.xspeedit.domain.Livraison;

/**
 * Implémentation optimisée du service d'emballage
 * Prend les articles les uns après les autres, et verifie chaque carton pour trouver un carton avec la capacité egale à l'article,
 * sinon verifie chaque carton pour trouver un carton avec de la place.
 * Si aucun carton n'a la capacité suffisante, le robot met l'article dans un nouveau carton.
 * @author royar
 *
 */
public class Optimise2EmballageService implements EmballageService {
	
	/** Repo de l'espace de stockage */
	EspaceDeStockageRepository espaceDeStockageRepository; 

	/** Constructeur */
	public Optimise2EmballageService() {
	}
	
	/** Constructeur avec le repo */
	public Optimise2EmballageService(EspaceDeStockageRepository espaceDeStockageRepository) {
		this.espaceDeStockageRepository = espaceDeStockageRepository;
	}
	

	@Override
	public void emballer(Article[] chaineDArticles) {
		EspaceDeStockage espaceDeStockage = espaceDeStockageRepository.loadEspaceDeStockage();
		
		if (espaceDeStockage.size() == 0) {
			espaceDeStockage.add(new Carton());
		}
		
		Arrays.stream(chaineDArticles).forEachOrdered(article -> {
			boolean isArticleEmballe = false;
			for (Carton carton : espaceDeStockage) {
				if (carton.getCapaciteRestante() == article.getTaille()) {
					carton.addArticle(article);
					isArticleEmballe = true;
					break;
				}
			}
			if (!isArticleEmballe) {
				for (Carton carton : espaceDeStockage) {
					if (carton.getCapaciteRestante() >= article.getTaille()) {
						carton.addArticle(article);
						isArticleEmballe = true;
						break;
					}
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
	public Carton[] getCartonsEnStock() {
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
	
	@Override
	public List<Livraison> getLivraison() {
		return this.espaceDeStockageRepository.loadEspaceDeStockage().getLivraisons();
	}

}
