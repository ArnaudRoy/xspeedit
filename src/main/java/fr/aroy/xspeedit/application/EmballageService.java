package fr.aroy.xspeedit.application;

import java.util.List;

import fr.aroy.xspeedit.domain.Article;
import fr.aroy.xspeedit.domain.Carton;
import fr.aroy.xspeedit.domain.EspaceDeStockageRepository;
import fr.aroy.xspeedit.domain.Livraison;

/**
 * Service d'emballage d'articles dans des cartons
 * @author royar
 *
 */
public interface EmballageService {
	
	/**
	 * Emballe les articles dans des cartons
	 * @param chaineDArticle a emballer
	 */
	void emballer(Article[] chaineDArticle);

	/**
	 * Retourne les cartons de l'espace de stockage
	 * @return Carton[] cartons a livrer
	 */
	Carton[] getCartonsEnStock();
	
	/**
	 * Retourne les livraison
	 * @return List<Livraison> livraisons
	 */
	List<Livraison> getLivraison();

	/**
	 * Setter du repo
	 * @param espaceDeStockageRepository
	 */
	void setEspaceDeStockageRepository(EspaceDeStockageRepository espaceDeStockageRepository);

}
